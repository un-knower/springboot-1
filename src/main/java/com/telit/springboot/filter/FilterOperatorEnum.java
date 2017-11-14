package com.telit.springboot.filter;

public enum FilterOperatorEnum {

    /** 等于 */
    eq,

    /** 不等于 */
    ne,

    /** 大于 */
    gt,

    /** 小于 */
    lt,

    /** 大于等于 */
    ge,

    /** 小于等于 */
    le,

    /** 相似 */
    like,

    /** 包含 */
    in,

    /** 为Null */
    isNull,

    /** 不为Null */
    isNotNull;

    /**
     * 从String中获取Operator
     * 
     * @param value
     *            值
     * @return String对应的operator
     */
    public static FilterOperatorEnum fromString(String value) {
        return FilterOperatorEnum.valueOf(value.toLowerCase());
    }
}
