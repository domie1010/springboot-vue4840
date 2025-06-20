package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MeishiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 美食
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("meishi")
public class MeishiView extends MeishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 美食类型的值
	*/
	@ColumnInfo(comment="美食类型的字典表值",type="varchar(200)")
	private String meishiValue;

	//级联表 农家乐商家
		/**
		* 商家姓名
		*/

		@ColumnInfo(comment="商家姓名",type="varchar(200)")
		private String shangjiaName;
		/**
		* 商家头像
		*/

		@ColumnInfo(comment="商家头像",type="varchar(200)")
		private String shangjiaPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String shangjiaIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String shangjiaPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String shangjiaEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shangjiaDelete;



	public MeishiView() {

	}

	public MeishiView(MeishiEntity meishiEntity) {
		try {
			BeanUtils.copyProperties(this, meishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 美食类型的值
	*/
	public String getMeishiValue() {
		return meishiValue;
	}
	/**
	* 设置： 美食类型的值
	*/
	public void setMeishiValue(String meishiValue) {
		this.meishiValue = meishiValue;
	}


	//级联表的get和set 农家乐商家

		/**
		* 获取： 商家姓名
		*/
		public String getShangjiaName() {
			return shangjiaName;
		}
		/**
		* 设置： 商家姓名
		*/
		public void setShangjiaName(String shangjiaName) {
			this.shangjiaName = shangjiaName;
		}

		/**
		* 获取： 商家头像
		*/
		public String getShangjiaPhoto() {
			return shangjiaPhoto;
		}
		/**
		* 设置： 商家头像
		*/
		public void setShangjiaPhoto(String shangjiaPhoto) {
			this.shangjiaPhoto = shangjiaPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getShangjiaIdNumber() {
			return shangjiaIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setShangjiaIdNumber(String shangjiaIdNumber) {
			this.shangjiaIdNumber = shangjiaIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getShangjiaPhone() {
			return shangjiaPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setShangjiaPhone(String shangjiaPhone) {
			this.shangjiaPhone = shangjiaPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getShangjiaEmail() {
			return shangjiaEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setShangjiaEmail(String shangjiaEmail) {
			this.shangjiaEmail = shangjiaEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShangjiaDelete() {
			return shangjiaDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShangjiaDelete(Integer shangjiaDelete) {
			this.shangjiaDelete = shangjiaDelete;
		}


	@Override
	public String toString() {
		return "MeishiView{" +
			", meishiValue=" + meishiValue +
			", shangjiaName=" + shangjiaName +
			", shangjiaPhoto=" + shangjiaPhoto +
			", shangjiaIdNumber=" + shangjiaIdNumber +
			", shangjiaPhone=" + shangjiaPhone +
			", shangjiaEmail=" + shangjiaEmail +
			", shangjiaDelete=" + shangjiaDelete +
			"} " + super.toString();
	}
}
