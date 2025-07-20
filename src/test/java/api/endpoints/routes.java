package api.endpoints;

public class routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//user
	
	public static String post_user= base_url+"/user";
	public static String get_user= base_url+"/user/{username}";
	public static String update_user= base_url+"/user/{username}";
	public static String delete_user= base_url+"/user/{username}";
	
	public static String login_user= base_url+"/user/login";
	public static String logout_user= base_url+"/user/logout";

}
