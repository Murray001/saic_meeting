package com.saic.meeting.api.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {

    /**
     * 返回码
     */
    private String statusCode;
    /**
     * 返回消息
     */
    private String statusMsg;
    /**
     * 请求的时间戳
     */
    private String timestamp;
    /**
     * 返回请求内容
     */
    private Map<String, Object> resMap;


    public static Results success(String statusCode, String statusMsg, String timestamp, Map<String, Object> resMap) {
        Results results = new Results(statusCode, statusMsg, timestamp, resMap);
        return results;
    }

    public static Results success(String timestamp, Object data) {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("data", data);
        return success(Contents.requestSuccess, Contents.getMsg4Code(Contents.requestSuccess), timestamp, resMap);
    }


    public static Results success(String timestamp) {
        return success(Contents.requestSuccess, Contents.getMsg4Code(Contents.requestSuccess), timestamp, null);
    }

    public static Results fail(String statusCode, String statusMsg, String timestamp, Map<String, Object> resMap) {
        Results results = new Results(statusCode, statusMsg, timestamp, resMap);
        return results;
    }

    public static Results requestFail(String timestamp) {
        return fail(Contents.requestFail, Contents.getMsg4Code(Contents.requestFail), timestamp, null);
    }

    /**
     * msg自定义 返回
     *
     * @param timestamp
     * @param msg
     * @return
     */
    public static Results requestFailMsg(String timestamp, String msg) {
        return fail(Contents.requestFail, msg, timestamp, null);
    }

    public static Results addFail(String timestamp) {
        return fail(Contents.addFail, Contents.getMsg4Code(Contents.addFail), timestamp, null);
    }


    public static Results updateFail(String timestamp) {
        return fail(Contents.updateFail, Contents.getMsg4Code(Contents.updateFail), timestamp, null);
    }

    public static Results deleteFail(String timestamp) {
        return fail(Contents.deleteFail, Contents.getMsg4Code(Contents.deleteFail), timestamp, null);
    }

    public static Results noLoginFail(String timestamp) {
        return success(Contents.noneLogin, Contents.getMsg4Code(Contents.noneLogin), timestamp, null);
    }

    /**
     * 根据条数以及type决定返回code,msg
     *
     * @param timestamp
     * @param count
     * @param type
     * @return
     */
    public static Results returnByCount(String timestamp, int count, String type) {
        if (count >= 1) {
            return success(timestamp);
        } else if ("新增".equals(type) || "保存".equals(type)) {
            return addFail(timestamp);
        } else if ("修改".equals(type) || "更新".equals(type)) {
            return updateFail(timestamp);
        } else if ("删除".equals(type)) {
            return deleteFail(timestamp);
        } else {
            return requestFail(timestamp);
        }
    }

}
