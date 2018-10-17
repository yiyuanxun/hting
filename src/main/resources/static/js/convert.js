/* 菜单数据转换器*/
function convert(leftNav) {
	var list = [];
	var has = false;
	for(var i in leftNav) {
		if(list.length > 0) {
			for(var y in list) {
				if(list[y].text == leftNav[i].text) {
					list[y].dson.push(leftNav[i]);
					has = true;
				}
			}
		}
		if(!has) {
			var json = {};
			json.text = leftNav[i].text;
			json.dson = []
			json.dson.push(leftNav[i])
			list.push(json)
		}
		has = false
	}
	return list;
}

/* 主题样式设定器*/
function setStyleSheet(title) {

	var doc_head = document.head;
	var link_list = document.getElementsByTagName("link");
	if(link_list) {
		for(var i = 0; i < link_list.length; i++) {
			// 找到我们需要替换的link，
			if(link_list[i].getAttribute("ty") === "theme") {
				doc_head.removeChild(link_list[i]);
			}
		}
	}
	// 创建一个新link标签
	var link_style = document.createElement("link");
	link_style.setAttribute("rel", "stylesheet");
	link_style.setAttribute("type", "text/css");
	link_style.setAttribute("href", title);
	link_style.setAttribute("ty", "theme");
	doc_head.appendChild(link_style);
};

// 导航栏收缩
function navHide(t, st) {
	var time = t ? t : 50;
	st ? localStorage.log = 1 : localStorage.log = 0;
	$('.my-side').animate({
		'left': -200
	}, time);
	$('.my-body').animate({
		'left': 0
	}, time);
	$('.my-footer').animate({
		'left': 0
	}, time);
}

// 导航栏展开
function navShow(t, st) {
	var time = t ? t : 50;
	st ? localStorage.log = 0 : localStorage.log = 1;
	$('.my-side').animate({
		'left': 0
	}, time);
	$('.my-body').animate({
		'left': 200
	}, time);
	$('.my-footer').animate({
		'left': 200
	}, time);
}