package com.cristik.common.base;

/**
 * Created by zhenghua on 2016/6/1.
 */
public class StatusCode {

    public static final int SUCCESS = 200;//请求成功

    public static final int COMMON_FAIL = 300;//默认错误

    public static final int SYSTEM_ERROR = 500;//系统错误

    public static final int UNKNOWN_ACCOUNT = 100;//用户不存在

    public static final int DISABLED_ACCOUNT = 101;//账户不可用

    public static final int LOCKED_ACCOUNT =102;//账户已锁定

    public static final int EXCESSIVE_ATTEMPS = 103;//登陆次数过多

    public static final int INCORRECT_CREDENTIALS = 104;//凭证错误

    public static final int EXPIRED_CREDENTIALS = 105;//凭证过期

}
