package com.entity.vo;

import com.entity.ShangjiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农家乐商家
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shangjia")
public class ShangjiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 商家姓名
     */

    @TableField(value = "shangjia_name")
    private String shangjiaName;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 商家头像
     */

    @TableField(value = "shangjia_photo")
    private String shangjiaPhoto;


    /**
     * 身份证号
     */

    @TableField(value = "shangjia_id_number")
    private String shangjiaIdNumber;


    /**
     * 联系方式
     */

    @TableField(value = "shangjia_phone")
    private String shangjiaPhone;


    /**
     * 电子邮箱
     */

    @TableField(value = "shangjia_email")
    private String shangjiaEmail;


    /**
     * 逻辑删除
     */

    @TableField(value = "shangjia_delete")
    private Integer shangjiaDelete;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：商家姓名
	 */
    public String getShangjiaName() {
        return shangjiaName;
    }


    /**
	 * 获取：商家姓名
	 */

    public void setShangjiaName(String shangjiaName) {
        this.shangjiaName = shangjiaName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：商家头像
	 */
    public String getShangjiaPhoto() {
        return shangjiaPhoto;
    }


    /**
	 * 获取：商家头像
	 */

    public void setShangjiaPhoto(String shangjiaPhoto) {
        this.shangjiaPhoto = shangjiaPhoto;
    }
    /**
	 * 设置：身份证号
	 */
    public String getShangjiaIdNumber() {
        return shangjiaIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setShangjiaIdNumber(String shangjiaIdNumber) {
        this.shangjiaIdNumber = shangjiaIdNumber;
    }
    /**
	 * 设置：联系方式
	 */
    public String getShangjiaPhone() {
        return shangjiaPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setShangjiaPhone(String shangjiaPhone) {
        this.shangjiaPhone = shangjiaPhone;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getShangjiaEmail() {
        return shangjiaEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setShangjiaEmail(String shangjiaEmail) {
        this.shangjiaEmail = shangjiaEmail;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShangjiaDelete() {
        return shangjiaDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShangjiaDelete(Integer shangjiaDelete) {
        this.shangjiaDelete = shangjiaDelete;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
