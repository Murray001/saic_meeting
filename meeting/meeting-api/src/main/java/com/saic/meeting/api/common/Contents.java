package com.saic.meeting.api.common;


/**
 * 常量工具类
 */
public class Contents {
	
	//redis0-15 库分配用户管理使用0
	public static int userIndexdb=0;
	
	//redis0-15 库分配初始化数据存入使用1
	public static int initResIndexdb=1;

	//redis0-15 库分配初始化数据存入使用1
	public static int initCaseIndexdb=2;

	//redis0-15 库分配初始化数据存入使用1
	public static int initSysRunIndexdb=3;

	//流水号存放位置
	public static int caseSerialIndexdb = 15;
	
	//登陆缓存有效期
	public static int redisLoginTimeOut = 3600;//单位秒

	//APP登陆缓存有效期
	public static int appRedisLoginTimeOut = 180000;

	//流水号锁定时间
	public static int caseSerialTimeOut = 3600;

	//webToken md5加密
	public static String keyStr = "longjin2019shanghai";
	

	//redis角色资源权限key串
	public static String roleResAuth = "resourcesAuth";
	
	//业务请求成功
	public static String requestSuccess = "200";
	
	//业务请求失败
	public static String requestFail = "201";
	
	//用户未登陆或登陆超时
	public static String noneLogin = "102";
	
	//两次Token不一致
	public static String authTokenFail = "103";
	
	//Webtoken验证不正确
	public static String authWebtokenFail = "105";
	
	//删除失败
	public static String deleteFail = "107";
	
	//新增失败
	public static String addFail = "108";
	
	//更新失败
	public static String updateFail = "109";
	
	//没有访问权限
	public static String requestAuthFail = "110";


	public static String getMsg4Code(String code) {
		String str = "未知";
		switch (code) {
		case "100":
			str = "登录成功";
			break;
		case "101":
			str = "用户名或密码不正确";
			break;
		case "102":
			str = "用户未登陆或登陆超时";
			break;
		case "103":
			str = "两次Token不一致";
			break;
		case "104":
			str = "退出登录成功";
			break;
		case "105":
			str = "Webtoken验证不正确";
			break;
		case "106":
			str = "验证码输入不正确";
			break;
		case "107":
			str = "删除失败";
			break;
		case "108":
			str = "新增失败";
			break;
		case "109":
			str = "更新失败";
			break;
		case "110":
			str = "没有访问权限";
			break;
		case "111":
			str = "前后端token不一致或已过期";
			break;
		case "200":
			str = "请求处理成功";
			break;
		case "201":
			str = "请求处理失败";
			break;
		default:
			str = "其他";
			break;
		}
		
		return str;
	}

}
