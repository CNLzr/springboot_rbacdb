var aList = document.querySelectorAll('.nav-list h2');
var aHide = document.querySelectorAll('.hide');
var aIcon = document.querySelectorAll('.nav-list i');
var lastIndex = 0;  //保存上一次的下标
for (var i = 0; i < aList.length; i++) {
    aList[i].index = i;  //自定义属性保存下标
    aList[i].isClick = false; //初始没有被点击
    aList[i].onclick = function(){  //点击事件执行函数
        //清除上一次的样式 lastIndex上一次的下标
        aHide[lastIndex].style.height = '0';
        aList[lastIndex].className = ''; //变换颜色
        aIcon[lastIndex].className = ''; //改变小图标的角度
        if (this.isClick) {  //被点击了
            this.isClick = false;
        }else{  //没有被点击
            var chartDiv = document.getElementById('userList');
            let moudel_num = this.nextElementSibling.children.length;
            console.log(chartDiv.offsetHeight);
            //设置当前样式 this.index  当前的下标
            aHide[this.index].style.height = (chartDiv.offsetHeight * moudel_num) +'px';  //设置css属性  变换hide的高度
            aList[this.index].className = 'on';  //变换颜色
            aIcon[this.index].className = 'on';  //改变小图标的角度
            //保存上一次下标
            aList[lastIndex].isClick = false;
            this.isClick = true;
            lastIndex = this.index; //保存上一次的样式
        };
    }
};