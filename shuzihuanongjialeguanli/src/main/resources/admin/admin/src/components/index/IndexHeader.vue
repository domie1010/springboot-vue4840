<template>
	<div class="navbar" :style="{background:heads.headBgColor,height:heads.headHeight,boxShadow:heads.headBoxShadow,lineHeight:heads.headHeight}">
		<div class="title-menu" :style="{justifyContent:heads.headTitleStyle=='1'?'flex-start':'center'}">
			<el-image v-if="heads.headTitleImg" class="title-img" :style="{width:heads.headTitleImgWidth,height:heads.headTitleImgHeight,boxShadow:heads.headTitleImgBoxShadow,borderRadius:heads.headTitleImgBorderRadius}" :src="heads.headTitleImgUrl" fit="cover"></el-image>
			<div class="title-name" :style="{color:heads.headFontColor,fontSize:heads.headFontSize}">{{this.$project.projectName}}</div>
		</div>
		<div class="right-menu">
			<!-- <div @click="opendialogFormVisible(1)" class="user-info" :style="{color:heads.headUserInfoFontColor,fontSize:heads.headUserInfoFontSize}">数据备份</div>
			<div @click="opendialogFormVisible(2)"  class="user-info" :style="{color:heads.headUserInfoFontColor,fontSize:heads.headUserInfoFontSize}">数据还原</div>
 -->			<div class="user-info" :style="{color:heads.headUserInfoFontColor,fontSize:heads.headUserInfoFontSize}">{{this.$storage.get('role')}} {{this.$storage.get('adminName')}}</div>
			<div class="logout" :style="{color:heads.headLogoutFontColor,fontSize:heads.headLogoutFontSize}" @click="onLogout">退出登录</div>
		</div>
		
		<el-dialog :title="beifendaoruType==1?'数据备份':'数据导入'" :modal='false' :visible.sync="dialogFormVisible">
			<el-form ref="ruleForm" :model="ruleForm" :rules="rules">
				<el-form-item label="MySQL安装目录" prop="mysqlUrl">
				  <el-input v-model="ruleForm.mysqlUrl"></el-input>
				</el-form-item>
			    <el-form-item label="MySQL数据库所在服务器地址IP" prop="hostIP">
				  <el-input v-model="ruleForm.hostIP"></el-input>
				</el-form-item>
				<el-form-item label="进入数据库所需要的用户名" prop="userName">
				  <el-input v-model="ruleForm.userName"></el-input>
				</el-form-item>
				<el-form-item label="数据库端口" prop="hostPort">
				  <el-input v-model="ruleForm.hostPort"></el-input>
				</el-form-item>
				<el-form-item label="进入数据库所需要的密码" prop="password">
				  <el-input v-model="ruleForm.password"></el-input>
				</el-form-item>
				<el-form-item label="数据库文件保存路径" prop="savePath">
				  <el-input v-model="ruleForm.savePath"></el-input>
				</el-form-item>
				<el-form-item label="数据库导出文件文件名(.sql结尾)" prop="fileName">
				  <el-input v-model="ruleForm.fileName"></el-input>
				</el-form-item>
				<el-form-item label="要导出的数据库名" prop="databaseName">
				  <el-input v-model="ruleForm.databaseName"></el-input>
				</el-form-item>
			</el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="dialogFormVisible = false">取 消</el-button>
		    <el-button type="primary" @click="beifen()">确 定</el-button>
		  </div>
		</el-dialog>
		
	</div>
</template>
shuzihuanongjialeguanli
<script>
	export default {
		data() {
			return {
				dialogVisible: false,
				
				user: {},
				dialogFormVisible:false,
				heads: {"headLogoutFontHoverColor":"#fff","headFontSize":"20px","headUserInfoFontColor":"#fff","headBoxShadow":"0 1px 6px #444","headTitleImgHeight":"44px","headLogoutFontHoverBgColor":"var(--publicSubColor)","headFontColor":"rgba(255, 255, 255, 1)","headTitleImg":false,"headHeight":"60px","headTitleImgBorderRadius":"22px","headTitleImgUrl":"http://codegen.caihongy.cn/20201021/cc7d45d9c8164b58b18351764eba9be1.jpg","headBgColor":"linear-gradient(90deg, var(--publicMainColor) 0%, var(--publicMainColor) 24%, var(--publicSubColor) 49%, var(--publicSubColor) 49%, var(--publicMainColor) 72%, var(--publicMainColor) 100%)","headTitleImgBoxShadow":"0 1px 6px #444","headLogoutFontColor":"#fff","headUserInfoFontSize":"16px","headTitleImgWidth":"44px","headTitleStyle":"2","headLogoutFontSize":"16px"},
				beifendaoruType:1,
				ruleForm: {
					mysqlUrl:"C:/Program Files/MySQL/MySQL Server 5.7/bin/",//MySQL安装目录
					hostIP:'127.0.0.1',//MySQL数据库所在服务器地址IP
					userName:'',//进入数据库所需要的用户名
					hostPort:'3306',//数据库端口
					password:'',//进入数据库所需要的密码
					savePath:'',//数据库导出文件保存路径
					fileName:"",//数据库导出文件文件名
					databaseName:"",//要导出的数据库名
				},
				rules: {
					mysqlUrl: [
						{ required: true, message: 'MySQL安装目录不能为空', trigger: 'blur' },
					],
					hostIP: [
						{ required: true, message: 'MySQL数据库所在服务器地址IP不能为空', trigger: 'blur' },
					],
					userName: [
						{ required: true, message: '进入数据库所需要的用户名不能为空', trigger: 'blur' },
					],
					hostPort: [
						{ required: true, message: '数据库端口不能为空', trigger: 'blur' },
					],
					password: [
						{ required: true, message: '进入数据库所需要的密码不能为空', trigger: 'blur' },
					],
					savePath: [
						{ required: true, message: '数据库导出文件保存路径不能为空', trigger: 'blur' },
					],
					fileName: [
						{ required: true, message: '数据库导出文件文件名不能为空', trigger: 'blur' },
					],
					databaseName: [
						{ required: true, message: '要导出的数据库名不能为空', trigger: 'blur' },
					],
				}
			};
		},
		created() {
			this.setHeaderStyle()
		},
		mounted() {
			let sessionTable = this.$storage.get("sessionTable")
			this.$http({
				url: sessionTable + '/session',
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					this.user = data.data;
					this.$storage.set('userid',data.data.id);
				} else {
					let message = this.$message
					message.error(data.msg);
				}
			});
		},
		methods: {
			opendialogFormVisible(types){
				this.beifendaoruType = types
				this.dialogFormVisible = true
			},
			beifen(){
				let _this = this
				let typesUrl = null
				if(_this.beifendaoruType == 1){
					typesUrl = '/beifen'
				}else{
					typesUrl = '/huanyun'
				}
				_this.ruleForm.hostIP = _this.ruleForm.hostIP.replaceAll("\\","/")
				_this.ruleForm.savePath = _this.ruleForm.savePath.replaceAll("\\","/")
				_this.$refs["ruleForm"].validate(valid => {
					if (valid) {
						_this.$http({
							url: typesUrl+'?hostIP='+_this.ruleForm.hostIP
										 +"&userName="+_this.ruleForm.userName
										 +"&hostPort="+_this.ruleForm.hostPort
										 +"&password="+_this.ruleForm.password
										 +"&savePath="+_this.ruleForm.savePath
										 +"&fileName="+_this.ruleForm.fileName
										 +"&databaseName="+_this.ruleForm.databaseName
										 +"&mysqlUrl="+_this.ruleForm.mysqlUrl
										 ,
							method: "get",
						}).then(({
							data
						}) => {
							if (data && data.code === 0) {
							    this.$message({
							        message: "操作成功",
							        type: "success",
							        duration: 1500,
							        onClose: () => {
							        }
							    });
							} else {
							    this.$message.error(data.msg);
							}
							_this.ruleForm={
								mysqlUrl:'C:/Program Files/MySQL/MySQL Server 5.7/bin/',//MySQL数据库所在服务器地址IP
								hostIP:'127.0.0.1',//MySQL数据库所在服务器地址IP
								userName:null,//进入数据库所需要的用户名
								hostPort:'3306',//数据库端口
								password:null,//进入数据库所需要的密码
								savePath:null,//数据库导出文件保存路径
								fileName:null,//数据库导出文件文件名
								databaseName:null,//要导出的数据库名
							}
							_this.dialogFormVisible = false
						});
					}
				})
			},
			onLogout() {
				let storage = this.$storage
				let router = this.$router
				storage.clear()
				router.replace({
					name: "login"
				});
			},
			onIndexTap(){
				window.location.href = `${this.$base.indexUrl}`
			},
			setHeaderStyle() {
			  this.$nextTick(()=>{
			    document.querySelectorAll('.navbar .right-menu .logout').forEach(el=>{
			      el.addEventListener("mouseenter", e => {
			        e.stopPropagation()
			        el.style.backgroundColor = this.heads.headLogoutFontHoverBgColor
					el.style.color = this.heads.headLogoutFontHoverColor
			      })
			      el.addEventListener("mouseleave", e => {
			        e.stopPropagation()
			        el.style.backgroundColor = "transparent"
					el.style.color = this.heads.headLogoutFontColor
			      })
			    })
			  })
			},
		}
	};
</script>


<style lang="scss" scoped>
	.navbar {
		height: 60px;
		line-height: 60px;
		width: 100%;
		padding: 0 34px;
		box-sizing: border-box;
		background-color: #ff00ff;
		position: relative;
		z-index: 111;
		
		.right-menu {
			position: absolute;
			right: 34px;
			top: 0;
			height: 100%;
			display: flex;
			justify-content: flex-end;
			align-items: center;
			z-index: 111;
			
			.user-info {
				font-size: 16px;
				color: red;
				padding: 0 12px;
			}
			
			.logout {
				font-size: 16px;
				color: red;
				padding: 0 12px;
				cursor: pointer;
			}
			
		}
		
		.title-menu {
			display: flex;
			justify-content: flex-start;
			align-items: center;
			width: 100%;
			height: 100%;
			
			.title-img {
				width: 44px;
				height: 44px;
				border-radius: 22px;
				box-shadow: 0 1px 6px #444;
				margin-right: 16px;
			}
			
			.title-name {
				font-size: 24px;
				color: #fff;
				font-weight: 700;
			}
		}
	}
	// .el-header .fr {
	// 	float: right;
	// }

	// .el-header .fl {
	// 	float: left;
	// }

	// .el-header {
	// 	width: 100%;
	// 	color: #333;
	// 	text-align: center;
	// 	line-height: 60px;
	// 	padding: 0;
	// 	z-index: 99;
	// }

	// .logo {
	// 	width: 60px;
	// 	height: 60px;
	// 	margin-left: 70px;
	// }

	// .avator {
	// 	width: 40px;
	// 	height: 40px;
	// 	background: #ffffff;
	// 	border-radius: 50%;
	// }

	// .title {
	// 	color: #ffffff;
	// 	font-size: 20px;
	// 	font-weight: bold;
	// 	margin-left: 20px;
	// }
</style>
