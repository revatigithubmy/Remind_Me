package com.revati.pojo;

public class User {
		static int uid;
		static String uname, ucontact, uemail;
		
		public static int getUid() {
			return uid;
		}
		
		public static void setUid(int uid) {
			User.uid = uid;
		}
		
		public static String getUname() {
			return uname;
		}
		
		public static void setUname(String uname) {
			User.uname = uname;
		}
		
		public static String getUcontact() {
			return ucontact;
		}
		
		public static void setUcontact(String ucontact) {
			User.ucontact = ucontact;
		}
		
		public static String getUemail() {
			System.out.println("getting uemail = "+uemail);
			return uemail;
		}
		
		public static void setUemail(String uemail) {
			System.out.println("setting uemail = "+uemail);
			User.uemail = uemail;
		}
		
}
