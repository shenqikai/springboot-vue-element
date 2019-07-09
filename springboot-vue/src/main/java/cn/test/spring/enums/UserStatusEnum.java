package cn.test.spring.enums;



/**
 * @author shenqikai
 *
 * 枚舉用戶狀太
 */
public enum UserStatusEnum {

    DELETED_USER("deleted","已經刪除");

    private String code;

    private String msg;

    UserStatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
