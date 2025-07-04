import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
// 解决多次点击左侧菜单报错问题
const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(to) {
	return VueRouterPush.call(this, to).catch(err => err)
}
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

import shangjia from '@/views/modules/shangjia/list'
import users from '@/views/modules/users/list'
import dictionary from '@/views/modules/dictionary/list'
import forum from '@/views/modules/forum/list'
import huodong from '@/views/modules/huodong/list'
import huodongYuyue from '@/views/modules/huodongYuyue/list'
import meishi from '@/views/modules/meishi/list'
import minsu from '@/views/modules/minsu/list'
import minsuCollection from '@/views/modules/minsuCollection/list'
import minsuCommentback from '@/views/modules/minsuCommentback/list'
import minsuOrder from '@/views/modules/minsuOrder/list'
import news from '@/views/modules/news/list'
import yonghu from '@/views/modules/yonghu/list'
import config from '@/views/modules/config/list'
import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
import dictionaryHuodong from '@/views/modules/dictionaryHuodong/list'
import dictionaryHuodongYuyueYesno from '@/views/modules/dictionaryHuodongYuyueYesno/list'
import dictionaryMeishi from '@/views/modules/dictionaryMeishi/list'
import dictionaryMinsu from '@/views/modules/dictionaryMinsu/list'
import dictionaryMinsuCollection from '@/views/modules/dictionaryMinsuCollection/list'
import dictionaryMinsuOrder from '@/views/modules/dictionaryMinsuOrder/list'
import dictionaryMinsuOrderPayment from '@/views/modules/dictionaryMinsuOrderPayment/list'
import dictionaryNews from '@/views/modules/dictionaryNews/list'
import dictionarySex from '@/views/modules/dictionarySex/list'
import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'





//2.配置路由   注意：名字
const routes = [{
		path: '/index',
		name: '首页',
		component: Index,
		children: [{
				// 这里不设置值，是把main作为默认页面
				path: '/',
				name: '首页',
				component: Home,
				meta: {
					icon: '',
					title: 'center'
				}
			}, {
				path: '/updatePassword',
				name: '修改密码',
				component: UpdatePassword,
				meta: {
					icon: '',
					title: 'updatePassword'
				}
			}, {
				path: '/pay',
				name: '支付',
				component: pay,
				meta: {
					icon: '',
					title: 'pay'
				}
			},
			{
				path: '/center',
				name: '个人信息',
				component: center,
				meta: {
					icon: '',
					title: 'center'
				}
			}, {
				path: '/huanyuan',
				name: '数据还原',
				component: huanyuan
			}, {
				path: '/beifen',
				name: '数据备份',
				component: beifen
			}, {
				path: '/users',
				name: '管理信息',
				component: users
			}, {
				path: '/dictionaryForumState',
				name: '帖子状态',
				component: dictionaryForumState
			}, {
				path: '/shangjia',
				name: '农家乐商家',
				component: shangjia
			}, 
			
			{
				path: '/dictionaryHuodong',
				name: '活动类型',
				component: dictionaryHuodong
			}, {
				path: '/dictionaryHuodongYuyueYesno',
				name: '订单类型',
				component: dictionaryHuodongYuyueYesno
			}, {
				path: '/dictionaryMeishi',
				name: '美食类型',
				component: dictionaryMeishi
			}, {
				path: '/dictionaryMinsu',
				name: '客房类型',
				component: dictionaryMinsu
			}, {
				path: '/dictionaryMinsuCollection',
				name: '收藏表类型',
				component: dictionaryMinsuCollection
			}, {
				path: '/dictionaryMinsuOrder',
				name: '订单类型',
				component: dictionaryMinsuOrder
			}, {
				path: '/dictionaryMinsuOrderPayment',
				name: '订单支付类型',
				component: dictionaryMinsuOrderPayment
			}, {
				path: '/dictionaryNews',
				name: '公告类型',
				component: dictionaryNews
			}, {
				path: '/dictionarySex',
				name: '性别',
				component: dictionarySex
			}, {
				path: '/dictionaryShangxia',
				name: '上下架',
				component: dictionaryShangxia
			}, {
				path: '/config',
				name: '轮播图',
				component: config
			}


			, {
				path: '/dictionary',
				name: '字典',
				component: dictionary
			}, {
				path: '/forum',
				name: '论坛',
				component: forum
			}, {
				path: '/huodong',
				name: '活动',
				component: huodong
			}, {
				path: '/huodongYuyue',
				name: '活动报名',
				component: huodongYuyue
			}, {
				path: '/meishi',
				name: '美食',
				component: meishi
			}, {
				path: '/minsu',
				name: '客房',
				component: minsu
			}, {
				path: '/minsuCollection',
				name: '客房收藏',
				component: minsuCollection
			}, {
				path: '/minsuCommentback',
				name: '客房评价',
				component: minsuCommentback
			}, {
				path: '/minsuOrder',
				name: '客房预定',
				component: minsuOrder
			}, {
				path: '/news',
				name: '公告信息',
				component: news
			}, {
				path: '/yonghu',
				name: '用户',
				component: yonghu
			}


		]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {
			icon: '',
			title: 'login'
		}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {
			icon: '',
			title: 'register'
		}
	},
	{
		path: '/',
		name: '首页',
		redirect: '/index'
	}, /*默认跳转路由*/
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})

export default router;
