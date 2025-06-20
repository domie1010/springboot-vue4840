const base = {
    get() {
        return {
            url : "http://localhost:8080/shuzihuanongjialeguanli/",
            name: "shuzihuanongjialeguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shuzihuanongjialeguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "数字化农家乐管理平台"
        } 
    }
}
export default base
