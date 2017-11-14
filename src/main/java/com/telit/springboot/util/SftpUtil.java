package com.telit.springboot.util;

import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
        import java.io.ByteArrayInputStream;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.io.UnsupportedEncodingException;
        import java.util.ArrayList;
        import java.util.Enumeration;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Properties;
        import java.util.Vector;
        import org.apache.commons.io.IOUtils;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import com.jcraft.jsch.Channel;
        import com.jcraft.jsch.ChannelSftp;
        import com.jcraft.jsch.ChannelSftp.LsEntry;
        import com.jcraft.jsch.JSch;
        import com.jcraft.jsch.JSchException;
        import com.jcraft.jsch.Session;
        import com.jcraft.jsch.SftpException;

/**
 * sftp工具。注意：构造方法有两个：分别是基于密码认证、基于秘钥认证。
 *
 * @see http://xliangwu.iteye.com/blog/1499764
 * @author Somnus
 */
public class SftpUtil {
    private transient Logger log = LoggerFactory.getLogger(this.getClass());

    private ChannelSftp sftp;

    private Session session;
    /** FTP 登录用户名*/
    private String username;
    /** FTP 登录密码*/
    private String password;
    /** 私钥文件的路径*/
    private String keyFilePath;
    /** FTP 服务器地址IP地址*/
    private String host;
    /** FTP 端口*/
    private int port;


    /**
     * 构造基于密码认证的sftp对象
     * @param userName
     * @param password
     * @param host
     * @param port
     */
    public SftpUtil(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    /**
     * 构造基于秘钥认证的sftp对象
     * @param userName
     * @param host
     * @param port
     * @param keyFilePath
     */
    public SftpUtil(String username, String host, int port, String keyFilePath) {
        this.username = username;
        this.host = host;
        this.port = port;
        this.keyFilePath = keyFilePath;
    }

    public SftpUtil(){}

    /**
     * 连接sftp服务器
     *
     * @throws Exception
     */
    public void login(){
        try {
            JSch jsch = new JSch();
            if (keyFilePath != null) {
                jsch.addIdentity(keyFilePath);// 设置私钥
                log.info("sftp connect,path of private key file：{}" , keyFilePath);
            }
            log.info("sftp connect by host:{} username:{}",host,username);

            session = jsch.getSession(username, host, port);
            log.info("Session is build");
            if (password != null) {
                session.setPassword(password);
            }
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.connect();
            log.info("Session is connected");

            Channel channel = session.openChannel("sftp");
            channel.connect();
            log.info("channel is connected");

            sftp = (ChannelSftp) channel;
            log.info(String.format("sftp server host:[%s] port:[%s] is connect successfull", host, port));
        } catch (JSchException e) {
            e.printStackTrace();
            log.error("Cannot connect to specified sftp server : {}:{} \n Exception message is: {}", new Object[]{host, port, e.getMessage()});
        }
    }

    /**
     * 关闭连接 server
     */
    public void logout(){
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
                log.info("sftp is closed already");
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
                log.info("sshSession is closed already");
            }
        }
    }

    /**
     * 将输入流的数据上传到sftp作为文件
     *
     * @param directory
     *            上传到该目录
     * @param sftpFileName
     *            sftp端文件名
     * @param in
     *            输入流
     * @throws SftpException
     * @throws Exception
     */
    public void upload(String directory, String sftpFileName, InputStream input) throws SftpException{
        try {
            sftp.cd(directory);
        } catch (SftpException e) {
            e.printStackTrace();
            log.warn("directory is not exist");
            sftp.mkdir(directory);
            sftp.cd(directory);
        }
        sftp.put(input, sftpFileName);
        log.info("file:{} is upload successful" , sftpFileName);
        System.out.println("file:"+sftpFileName+" is upload successful");
    }

    /**
     * 上传单个文件
     *
     * @param directory
     *            上传到sftp目录
     * @param uploadFile
     *            要上传的文件,包括路径
     * @throws FileNotFoundException
     * @throws SftpException
     * @throws Exception
     */
    public void upload(String directory, String uploadFile) throws FileNotFoundException, SftpException{
        File file = new File(uploadFile);
        upload(directory, file.getName(), new FileInputStream(file));
    }

    /**
     * 将byte[]上传到sftp，作为文件。注意:从String生成byte[]是，要指定字符集。
     *
     * @param directory
     *            上传到sftp目录
     * @param sftpFileName
     *            文件在sftp端的命名
     * @param byteArr
     *            要上传的字节数组
     * @throws SftpException
     * @throws Exception
     */
    public void upload(String directory, String sftpFileName, byte[] byteArr) throws SftpException{
        upload(directory, sftpFileName, new ByteArrayInputStream(byteArr));
    }

    /**
     * 将字符串按照指定的字符编码上传到sftp
     *
     * @param directory
     *            上传到sftp目录
     * @param sftpFileName
     *            文件在sftp端的命名
     * @param dataStr
     *            待上传的数据
     * @param charsetName
     *            sftp上的文件，按该字符编码保存
     * @throws UnsupportedEncodingException
     * @throws SftpException
     * @throws Exception
     */
    public void upload(String directory, String sftpFileName, String dataStr, String charsetName) throws UnsupportedEncodingException, SftpException{
        upload(directory, sftpFileName, new ByteArrayInputStream(dataStr.getBytes(charsetName)));

    }

    /**
     * 下载文件
     *
     * @param directory
     *            下载目录
     * @param downloadFile
     *            下载的文件
     * @param saveFile
     *            存在本地的路径
     * @throws SftpException
     * @throws FileNotFoundException
     * @throws Exception
     */
    public void download(String directory, String downloadFile, String saveFile) throws SftpException, FileNotFoundException{
        if (directory != null && !"".equals(directory)) {
            sftp.cd(directory);
        }
        File file = new File(saveFile);
        sftp.get(downloadFile, new FileOutputStream(file));
        log.info("file:{} is download successful" , downloadFile);
    }
    /**
     * 下载文件
     * @param directory 下载目录
     * @param downloadFile 下载的文件名
     * @return 字节数组
     * @throws SftpException
     * @throws IOException
     * @throws Exception
     */
    public byte[] download(String directory, String downloadFile) throws SftpException, IOException{
        if (directory != null && !"".equals(directory)) {
            sftp.cd(directory);
        }
        InputStream is = sftp.get(downloadFile);

        byte[] fileData = IOUtils.toByteArray(is);

        log.info("file:{} is download successful" , downloadFile);
        return fileData;
    }
    /**
     * 下载文件
     * @param directory 下载目录
     * @param downloadFile 下载的文件名
     * @return 字节数组
     * @throws SftpException
     * @throws IOException
     * @throws Exception
     */
    public InputStream downloadFile(String directory, String downloadFile) throws SftpException, IOException{
        if (directory != null && !"".equals(directory)) {
            sftp.cd(directory);
        }
        return sftp.get(downloadFile);
    }

    /**
     * 删除文件
     *
     * @param directory
     *            要删除文件所在目录
     * @param deleteFile
     *            要删除的文件
     * @throws SftpException
     * @throws Exception
     */
    public void delete(String directory, String deleteFile) throws SftpException{
        sftp.cd(directory);
        sftp.rm(deleteFile);
    }

    public void deleteDir(String path){
        try {
            sftp.rmdir(path);
        } catch (SftpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 列出目录下的文件
     *
     * @param directory
     *            要列出的目录
     * @param sftp
     * @return
     * @throws SftpException
     */
    public Vector<?> listFiles(String directory) throws SftpException {
        try {
            sftp.cd(directory);
        } catch (SftpException e) {
            log.warn("directory is not exist");
            sftp.mkdir(directory);
        }
        return sftp.ls(directory);
    }

    public static void main(String[] args) throws SftpException, IOException {
        SftpUtil sftp = new SftpUtil("root", "tlt12346", "220.178.53.9", 22);  //112.27.234.68
        sftp.login();
        List<String> list = new ArrayList<String>();
        List<String> returnList = new ArrayList<String>();
        Vector<?> vector = sftp.listFiles("/uploadFile/潜山路小学/acf089e198d248d48700920a599446b0/学困生材料/2016-2017学年度第一学期");
        Enumeration<?> enumeration = vector.elements();
        while(enumeration.hasMoreElements()){
            LsEntry lsEntry = (LsEntry)enumeration.nextElement();
            if(!lsEntry.getAttrs().isDir()){
                System.out.println("update staff_cloud_disk set file_size='"+lsEntry.getAttrs().getSize()+"' where cloud_disk_name='"+lsEntry.getFilename()+"';");
//	        	System.out.println(lsEntry.getFilename()+"###"+lsEntry.getAttrs().getSize());
            }
        }

//        for(String value:list){
//        	Vector<?> vector2 = sftp.listFiles("/home/git/resource/tomcat/webapps/uploadHtml"+"/"+value);
//        	Enumeration<?> enumeration2 = vector2.elements();
//        	while(enumeration2.hasMoreElements()){
//        		LsEntry lsEntry = (LsEntry)enumeration2.nextElement();
//    	        if(lsEntry.getFilename().contains("html")){
//    	        	System.out.println(value+"-->"+lsEntry.getFilename());
//    	        }
//            }
//        }
        sftp.logout();
    	/*FTPClient ftpClient = new FTPClient();
		//连接FTP服务器
		ftpClient.connect("112.27.234.68", 21);
		//登录FTP服务器
		ftpClient.login("telit_admin", "tlt@12346");
		//验证FTP服务器是否登录成功
		int replyCode = ftpClient.getReplyCode();
		ftpClient.changeWorkingDirectory("/userfiles/res/");
		FTPFile[] ftpFiles = ftpClient.listFiles();
		for(FTPFile file : ftpFiles){
			if("f6b0329f5d79429b89a812f306911c3d.mp4".equalsIgnoreCase(file.getName())){
				System.out.println(file.getName());
				File localFile = new File("d:\\" + file.getName());
				OutputStream os = new FileOutputStream(localFile);
				ftpClient.retrieveFile(file.getName(), os);
				os.close();
			}
		}
		ftpClient.logout(); */

//    	FTPClient ftpClient = new FTPClient();
//		ftpClient.setControlEncoding("utf-8");
//		ftpClient.connect("192.168.1.11", 22); //连接ftp服务器
//		ftpClient.login("firewarn", "tlt12346"); //登录ftp服务器
//		int replyCode = ftpClient.getReplyCode(); //是否成功登录服务器
//		System.out.println(replyCode);
//
//    	List<String> list = new ArrayList<String>();
//    	list.add("ew");
//    	list.add("sff");
//    	System.out.println(list.toString().substring(1,list.toString().length()-1));
    }

}

