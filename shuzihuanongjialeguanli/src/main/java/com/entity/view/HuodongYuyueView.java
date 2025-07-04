package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.HuodongYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 活动报名
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("huodong_yuyue")
public class HuodongYuyueView extends HuodongYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String huodongYuyueYesnoValue;

	//级联表 活动
		/**
		* 活动名称
		*/

		@ColumnInfo(comment="活动名称",type="varchar(200)")
		private String huodongName;
		/**
		* 活动照片
		*/

		@ColumnInfo(comment="活动照片",type="varchar(200)")
		private String huodongPhoto;
		/**
		* 活动类型
		*/
		@ColumnInfo(comment="活动类型",type="int(11)")
		private Integer huodongTypes;
			/**
			* 活动类型的值
			*/
			@ColumnInfo(comment="活动类型的字典表值",type="varchar(200)")
			private String huodongValue;
		/**
		* 活动介绍
		*/

		@ColumnInfo(comment="活动介绍",type="text")
		private String huodongContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer huodongDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public HuodongYuyueView() {

	}

	public HuodongYuyueView(HuodongYuyueEntity huodongYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, huodongYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getHuodongYuyueYesnoValue() {
		return huodongYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setHuodongYuyueYesnoValue(String huodongYuyueYesnoValue) {
		this.huodongYuyueYesnoValue = huodongYuyueYesnoValue;
	}


	//级联表的get和set 活动

		/**
		* 获取： 活动名称
		*/
		public String getHuodongName() {
			return huodongName;
		}
		/**
		* 设置： 活动名称
		*/
		public void setHuodongName(String huodongName) {
			this.huodongName = huodongName;
		}

		/**
		* 获取： 活动照片
		*/
		public String getHuodongPhoto() {
			return huodongPhoto;
		}
		/**
		* 设置： 活动照片
		*/
		public void setHuodongPhoto(String huodongPhoto) {
			this.huodongPhoto = huodongPhoto;
		}
		/**
		* 获取： 活动类型
		*/
		public Integer getHuodongTypes() {
			return huodongTypes;
		}
		/**
		* 设置： 活动类型
		*/
		public void setHuodongTypes(Integer huodongTypes) {
			this.huodongTypes = huodongTypes;
		}


			/**
			* 获取： 活动类型的值
			*/
			public String getHuodongValue() {
				return huodongValue;
			}
			/**
			* 设置： 活动类型的值
			*/
			public void setHuodongValue(String huodongValue) {
				this.huodongValue = huodongValue;
			}

		/**
		* 获取： 活动介绍
		*/
		public String getHuodongContent() {
			return huodongContent;
		}
		/**
		* 设置： 活动介绍
		*/
		public void setHuodongContent(String huodongContent) {
			this.huodongContent = huodongContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getHuodongDelete() {
			return huodongDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setHuodongDelete(Integer huodongDelete) {
			this.huodongDelete = huodongDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "HuodongYuyueView{" +
			", huodongYuyueYesnoValue=" + huodongYuyueYesnoValue +
			", huodongName=" + huodongName +
			", huodongPhoto=" + huodongPhoto +
			", huodongContent=" + huodongContent +
			", huodongDelete=" + huodongDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
