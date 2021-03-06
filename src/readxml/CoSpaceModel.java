package readxml;

import java.io.Serializable;

/**
 * 
 	* @author 刘楚城
 	* @ClassName: CospaceModel
 	* @ModifiedBy 
 	* @Copyright xxx
 	* @date 2017年1月10日 下午3:47:10
 	* @description acano 会议室管理
 */
public class CoSpaceModel implements Serializable{

	public CoSpaceModel() {
		// TODO Auto-generated constructor stub
	}
	
	private int id = 0;//主键标识
	//系统本身属性
	private String acano_coSpace_id;//acano平台cospace id值
	private String name;//会议室名称
	private String access_uri = "";//入会uri
	private String access_secondary_uri = "";//同上功能，备选入会uri
	private String access_call_id = "";//参会者进入会议室的入口id
	private String passcode = "";//会议室密码
	private String default_layout;//默认的视频布局（四个可选值：）
	private int call_profile_id;//对会议室中的会议属性进行配置！！！
	private int call_leg_profile_id;//对会议参会人权限进行管理的配置！！！
	private boolean require_call_id;//
	private boolean autoGenerated;//是否系统自动分配的会议室
	private String tenant;//会议室的所属租户ID
	private String secret;//会议室安全值
	private boolean nonmember_access = true;//非会议室成员是否可以参会，默认为true
	private String owner_jid;//会议室所属用户的jid
	
	
	private int site_id = 0;//站点id
	private int input_user_id = 0;//录入人
	private int modify_user_id = 0;//修改人
	private String input_time = "";//录入时间
	private String modify_time = "";//修改时间
	
	private String site_lic_type = "";//站点类型（不存数据库）
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcano_coSpace_id() {
		return acano_coSpace_id;
	}
	public void setAcano_coSpace_id(String acano_coSpace_id) {
		this.acano_coSpace_id = acano_coSpace_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccess_uri() {
		return access_uri;
	}
	public void setAccess_uri(String access_uri) {
		this.access_uri = access_uri;
	}
	public String getAccess_secondary_uri() {
		return access_secondary_uri;
	}
	public void setAccess_secondary_uri(String access_secondary_uri) {
		this.access_secondary_uri = access_secondary_uri;
	}
	public String getAccess_call_id() {
		return access_call_id;
	}
	public void setAccess_call_id(String access_call_id) {
		this.access_call_id = access_call_id;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getDefault_layout() {
		return default_layout;
	}
	public void setDefault_layout(String default_layout) {
		this.default_layout = default_layout;
	}
	public int getCall_profile_id() {
		return call_profile_id;
	}
	public void setCall_profile_id(int call_profile_id) {
		this.call_profile_id = call_profile_id;
	}
	public int getCall_leg_profile_id() {
		return call_leg_profile_id;
	}
	public void setCall_leg_profile_id(int call_leg_profile_id) {
		this.call_leg_profile_id = call_leg_profile_id;
	}
	public boolean isRequire_call_id() {
		return require_call_id;
	}
	public void setRequire_call_id(boolean require_call_id) {
		this.require_call_id = require_call_id;
	}
	public boolean isAutoGenerated() {
		return autoGenerated;
	}
	public void setAutoGenerated(boolean autoGenerated) {
		this.autoGenerated = autoGenerated;
	}
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public boolean isNonmember_access() {
		return nonmember_access;
	}
	public void setNonmember_access(boolean nonmember_access) {
		this.nonmember_access = nonmember_access;
	}
	public String getOwner_jid() {
		return owner_jid;
	}
	public void setOwner_jid(String owner_jid) {
		this.owner_jid = owner_jid;
	}
	public int getSite_id() {
		return site_id;
	}
	public void setSite_id(int site_id) {
		this.site_id = site_id;
	}
	public int getInput_user_id() {
		return input_user_id;
	}
	public void setInput_user_id(int input_user_id) {
		this.input_user_id = input_user_id;
	}
	public int getModify_user_id() {
		return modify_user_id;
	}
	public void setModify_user_id(int modify_user_id) {
		this.modify_user_id = modify_user_id;
	}
	public String getInput_time() {
		return input_time;
	}
	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}
	public String getModify_time() {
		return modify_time;
	}
	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}
	public String getSite_lic_type() {
		return site_lic_type;
	}
	public void setSite_lic_type(String site_lic_type) {
		this.site_lic_type = site_lic_type;
	}
	
	

}
