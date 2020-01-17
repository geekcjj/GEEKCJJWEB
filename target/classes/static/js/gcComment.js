/*
 * gcComment.js 搜索插件  http://www.doit666.com
 * by geekcjj 2015-03-06   QQ : 1789615426
 */
(function ($, undefined) {
    $.fn.gcComment = function (options, param) {
        var otherArgs = Array.prototype.slice.call(arguments, 1);
        if (typeof options == 'string') {
            var fn = this[0][options];
            if ($.isFunction(fn)) {
                return fn.apply(this, otherArgs);
            } else {
                throw ("gcComment - No such method: " + options);
            }
        }

        return this.each(function () {
            var para = {}; // 保留参数
            var self = this; // 保存组件对象
            var fCode = 0;

            var defaults = {
                "width": "355",
                "height": "33",
                "agoComment": [], // 以往评论内容
                "callback": function (comment) {
                    console.info("返回评论数据");
                    console.info(comment);
                }
            };

            para = $.extend(defaults, options);

            this.init = function () {
                this.createAgoCommentHtml(); // 创建以往评论的html
            };

            /**
             * 功能：创建以往评论的html
             * 参数: 无
             * 返回: 无 
             */
            this.createAgoCommentHtml = function () {

                var html = '';
                html += '<div id="commentItems" style="margin-bottom:4px;"></div>';
                /* html +=
                    '<div id="commentItems" class="ui threaded comments" style="margin-bottom:20px;">';
                html +=
                    '	<div class="text" style="font-size:2rem;padding-bottom:10px;border-bottom: 1px solid #DFDFDF;"> 大家的脚印 </div>';
                html += '</div>'; */
                $(self).append(html);

                $.each(para.agoComment, function (k, v) {

                    /* var topStyle = "";
                    if (k > 0) {
                        topStyle = "topStyle";
                    } */

                    var item = '';
                    item += '<div id="comment-lw' + v.id + '" class="comment-lw">';
                    item += '<div class="comment-main">';
                    item += '	<a class="user-logo">';
                    item += '		<img src="images/bloglogo.png">';
                    item += '	</a>';
                    item += '	<div class="comment-content">';
                    item += '		<div class="comment-info">';
                    item += '			<a> ' + v.nickName + ' </a>';
                    item += '			<span>' + v.createTime + ' </span>';
                    item += '		</div>';
                    item += '		<div class="comment-text"><span class="replyuser">'+(v.parentId==0?'':'@'+v.toNickName+':')+'</span>' + v.content + ' </div>';
                    item += '		<div class="comment-action">';
                    item += '			<a class="reply" href="javascript:void(0);" selfID="' + v.id +'" selfNickName="'+v.nickName+'">回复</a>';
                    item += '		</div>';
                    item += '	</div>';
                    item += '</div>';
                    item += '</div>';
                    var parentId=v.parentId;
                    // 判断此条评论是不是子级评论
                    if (parentId == 0) { // 不是
                        $("#commentItems").append(item);
                    } else { // 否
                        // 判断父级评论下是不是已经有了子级评论
                    	//console.log($('#comment-lw'+ parentId).find(".comments-lw").length);
                    	console.log(parentId);
                        if ($("#comment-lw" + parentId).find(".comments-lw").length == 0) { // 没有
                        	//$("#comment-lw" + v.id).find(".replyuser").html("@"+$("#comment-lw" + parentId).find(".comment-info").find("a").text()+":");
                        	var comments = '';
                            comments += '<div id="comments-lw' + parentId +'" class="comments-lw">';
                            comments += item;
                            comments += '</div>';

                            $("#comment-lw"+ parentId).append(comments);
                            //console.log($("#comments-lw" + v.parentId).html);
                        } else { // 有
                        	//$("#comment-lw" + v.id).find(".replyuser").html("@"+$("#comment-lw" + parentId).find(".comment-info").find("a").text()+":");
                            $("#comments-lw" + parentId).append(item);
                        }
                    }
                });
                //this.createFormCommentHtml(); // 创建发表评论的html
                // 初始化html之后绑定点击事件
                this.addEvent();
            };

            /**
             * 功能：创建评论form的html
             * 参数: 无
             * 返回: 无 
             */
//            this.createFormCommentHtml = function () {
//                // 先添加父容器
//                //$(self).append('<div class="contact-box" id="contact-box"></div>');
//                //var parentBox='<div class="contact-box" id="contact-box"></div>';
//                // 组织发表评论的form html代码
//                var boxHtml = '';
//                boxHtml += '<form id="ajax-contact-web-reply" action="" method="post">';
//                boxHtml +=
//                    '		<input type="text" hidden id="parentId" name="parentId" placeholder="父级ID*" value=""/>';
//                boxHtml += '	<div class="form-group row">';
//                boxHtml += '		<div class="col-lg-4 col-md-4 col-sm-4">';
//                boxHtml +=
//                    '			<input type="text" class="form-control" id="name-web" name="name" placeholder="姓名*" required="" />';
//                boxHtml += '		</div>';
//                boxHtml += '		<div class="col-lg-4 col-md-4 col-sm-4">';
//                boxHtml +=
//                    '			<input type="email" class="form-control" id="email-web" name="email" placeholder="Email*" required="" />';
//                boxHtml += '		</div>';
//                boxHtml += '		<div class="col-lg-4 col-md-4 col-sm-4">';
//                boxHtml +=
//                    '			<input type="text" class="form-control" id="myWebSite-web" name="myWebSite" placeholder="网址" />';
//                boxHtml += '		</div>';
//                boxHtml += '	</div>';
//                boxHtml += '	<div class="form-group">';
//                boxHtml += '		<textarea id="editordata-web" class="form-control" name="editordata-web" rows="3"></textarea>';
//                boxHtml += '	</div>';
//                boxHtml += '	<div class="form-group">';
//                boxHtml +=
//                    '		<button class="btn btn-primary" type="button" onclick="leaveMessageForMe()"><i class="icon edit"></i> 提交回复</button>';
//                boxHtml += '		<span id="callback-msg-web"></span>';
//                boxHtml += '	</div>';
//                boxHtml += '</form>';
//                $("#contact-box").append(boxHtml);
//
//                // 初始化html之后绑定点击事件
//                this.addEvent();
//            };

            /**
             * 功能：绑定事件
             * 参数: 无
             * 返回: 无
             */
            this.addEvent = function () {
                // 绑定item上的回复事件
            	this.replyClickEvent();

                // 绑定item上的取消回复事件
            	this.cancelReplyClickEvent();

                // 绑定回复框的事件
            	this.addFormEvent();
            };

            /**
             * 功能: 绑定item上的回复事件
             * 参数: 无
             * 返回: 无
             */
            this.replyClickEvent = function () {
                // 绑定回复按钮点击事件
                $(self).find(".comment-action .reply").on("click", function () {
                    // 设置当前回复的评论的id
                    fCode = $(this).attr("selfid");

                    // 1.移除之前的取消回复按钮
                    $(self).find(".cancel").remove();

                    // 2.移除所有回复框
                    self.removeAllCommentFrom();

                    // 3.添加取消回复按钮
                    $(this).parent(".comment-action").append('<a class="cancel" href="javascript:void(0);">取消回复</a>');

                    // 4.添加回复下的回复框
                    self.addReplyCommentFrom($(this).attr("selfID"),$(this).attr("selfNickName"));

                    // 绑定提交事件
//                    $("#publicComment").off("click");
//                    $("#publicComment").on("click", function () {
//                        var result = {
//                            "name": $("#userName").val(),
//                            "email": $("#userEmail").val(),
//                            "content": $("#commentContent").val()
//                        };
//                        para.callback(result);
//                    });
                });

            };

            /**
             * 功能: 绑定item上的取消回复事件
             * 参数: 无
             * 返回: 无
             */
            this.cancelReplyClickEvent = function () {
                $(self).find(".comment-action .cancel").off("click");
            	//console.log("点击了取消回复的按钮!");
                $(self).find(".comment-action").on("click",".cancel", function () {
                	//alert("开始运行事件");
                	// 1.移除之前的取消回复按钮
                    $(self).find(".cancel").remove();

                    // 2.移除所有回复框
                    self.removeAllCommentFrom();
                    console.log("点击了取消回复的按钮!");
                    // 3.添加根下的回复框
                    //self.addRootCommentFrom();
                });
            };

            /**
             * 功能: 绑定回复框的事件
             * 参数: 无
             * 返回: 无
             */
            this.addFormEvent = function () {
//                // 先解除绑定
//                $("textarea,input").off("focus");
//                $("textarea,input").off("blur");
//                // 绑定回复框效果
//                $("textarea,input").on("focus", function () {
//                    // 移除 失去焦点class样式，添加获取焦点样式
//                    $(this).next("label").removeClass("blur-foucs").addClass("foucs");
//                }).on("blur", function () {
//                    // 如果文本框没有值
//                    if ($(this).val() == '') {
//                        // 移除获取焦点样式添加原生样式
//                        if ($(this).attr("id") == "commentContent") {
//                            $(this).next("label").removeClass("foucs").addClass(
//                                "areadefault");
//                        } else {
//                            $(this).next("label").removeClass("foucs").addClass(
//                                "inputdefault");
//                        }
//                    } else { // 有值 添加失去焦点class样式
//                        $(this).next("label").addClass("blur-foucs");
//                    }
//                });

                // 绑定提交事件
//                $("#submitComment").off("click");
//                $("#submitComment").on("click", function () {
//                    var result = {
//                        "name": $("#userName").val(),
//                        "email": $("#userEmail").val(),
//                        "content": $("#commentContent").val()
//                    };
//                    para.callback(result);
//                });
            };

            // 添加回复下的回复框
            this.addReplyCommentFrom = function (id,nickName) {
                var boxHtml = '';
                boxHtml += '<form id="ajax-contact-web-reply" action="" method="post">';
                boxHtml +='		<input type="text" hidden id="parentId" name="parentId" value="'+id+'"/>';
                boxHtml +='		<input type="text" hidden id="nickName" name="nickName" value="'+nickName+'"/>';
                boxHtml += '	<div class="form-group row">';
                boxHtml += '		<div class="col-lg-4 col-md-4 col-sm-4">';
                boxHtml +=
                    '			<input type="text" class="form-control" id="name-web-reply" name="name" placeholder="姓名*" required="" />';
                boxHtml += '		</div>';
                boxHtml += '		<div class="col-lg-4 col-md-4 col-sm-4">';
                boxHtml +=
                    '			<input type="email" class="form-control" id="email-web-reply" name="email" placeholder="Email*" required="" />';
                boxHtml += '		</div>';
                boxHtml += '		<div class="col-lg-4 col-md-4 col-sm-4">';
                boxHtml +=
                    '			<input type="text" class="form-control" id="myWebSite-web-reply" name="myWebSite" placeholder="网址" />';
                boxHtml += '		</div>';
                boxHtml += '	</div>';
                boxHtml += '	<div class="form-group">';
                boxHtml += '		<textarea id="editordata-web-reply" class="form-control" name="editordata-web" rows="3"></textarea>';
                boxHtml += '	</div>';
                boxHtml += '	<div class="form-group">';
                boxHtml +='		<button class="btn btn-primary" id="closeReplyBtn" type="button"><i class="icon edit"></i>关闭</button>';
                boxHtml +='		<button class="btn btn-primary" id="lwReplyBtn" type="button"><i class="icon edit"></i> 提交回复</button>';
                boxHtml += '		<span id="callback-msg-web-reply"></span>';
                boxHtml += '	</div>';
                boxHtml += '</form>';

                $(self).find("#comment-lw" + id).find(">.comment-main").after(boxHtml);
                this.addCloseReply();
                this.addReplyBtn();
            };
            this.addCloseReply=function(){
            	// 移除评论下的回复框
            	$(self).find("#ajax-contact-web-reply #closeReplyBtn").off("click");
            	//console.log("点击了取消回复的按钮!");
                $(self).find("#ajax-contact-web-reply").on("click","#closeReplyBtn", function () {
                	//alert("开始运行事件");
                	// 1.移除之前的取消回复按钮
                	$(self).find(".comment-action .cancel").remove();

                    // 2.移除所有回复框
                    self.removeAllCommentFrom();
                    console.log("点击了取消回复的按钮!");
                    // 3.添加根下的回复框
                    //self.addRootCommentFrom();
                });
            }
            //留言回复事件
            this.addReplyBtn=function(){
            	$(self).find("#ajax-contact-web-reply").on("click","#lwReplyBtn", function () {
            		var datacontent=$("#ajax-contact-web-reply").serialize();
                	console.log('内容:'+datacontent);
                	if($("#editordata-web-reply").val()==""||$("#name-web-reply").val()==""||$("#email-web-reply").val()==""){
                		$("#callback-msg-web-reply").html("带*号为必填项!");
                	}else{
                		$.post("/leaveWords/blog/userLeaveWordsReply", 
        	        		datacontent,
        		          	function(data){
        			          	//alert(data.name); // John
        			          	console.log(data.data); //  2pm
        			          	if(data.data==true){
        			          		$("#callback-msg-web-reply").html("");
        			          		$("#editordata-web-reply").val('');
        			          		$("#name-web-reply").val('');
        			          		$("#email-web-reply").val('');
        			          		$("#myWebSite-web-reply").val('');
        			          		getAllUserLeaveWords();
        			          	}else{
        			          		$("#callback-msg-web-reply").html(data.data);
        			          		$("#editordata-web-reply").val('');
        			          		$("#name-web-reply").val('');
        			          		$("#email-web-reply").val('');
        			          		$("#myWebSite-web-reply").val('');
        			          	}
        			       }, "json");
                	}
            	})
            }
            // 移除所有回复框
            this.removeAllCommentFrom = function () {
                // 移除评论下的回复框
                if ($(self).find("#ajax-contact-web-reply")[0]) {
                    // 删除评论回复框
                    $(self).find("#ajax-contact-web-reply").remove();
                    console.log("移除回复框!");
                }

                // 删除文章回复框
//                if ($(self).find("#ajax-contact-web-reply")[0]) {
//                    $(self).find("#ajax-contact-web-reply").remove();
//                }
            };
            // 添加根下的回复框
//            this.addRootCommentFrom = function () {
//                var boxHtml = '';
//                boxHtml += '<form id="ajax-contact-web-reply" action="" method="post">';
//                boxHtml +=
//                    '		<input type="text" hidden id="parentId" name="parentId" placeholder="父级ID*" value=""/>';
//                boxHtml += '	<div class="form-group row">';
//                boxHtml += '		<div class="col-lg-4 col-md-4 col-sm-4">';
//                boxHtml +=
//                    '			<input type="text" class="form-control" id="name-web" name="name" placeholder="姓名*" required="" />';
//                boxHtml += '		</div>';
//                boxHtml += '		<div class="col-lg-4 col-md-4 col-sm-4">';
//                boxHtml +=
//                    '			<input type="email" class="form-control" id="email-web" name="email" placeholder="Email*" required="" />';
//                boxHtml += '		</div>';
//                boxHtml += '		<div class="col-lg-4 col-md-4 col-sm-4">';
//                boxHtml +=
//                    '			<input type="text" class="form-control" id="myWebSite-web" name="myWebSite" placeholder="网址" />';
//                boxHtml += '		</div>';
//                boxHtml += '	</div>';
//                boxHtml += '	<div class="form-group">';
//                boxHtml += '		<textarea id="editordata-web" class="form-control" name="editordata-web" rows="3"></textarea>';
//                boxHtml += '	</div>';
//                boxHtml += '	<div class="form-group">';
//                boxHtml +=
//                    '		<button class="btn btn-primary" type="button" onclick="leaveMessageForMe()"><i class="icon edit"></i> 提交回复</button>';
//                boxHtml += '		<span id="callback-msg-web"></span>';
//                boxHtml += '	</div>';
//                boxHtml += '</form>';
//
//                $(self).find("#contact-box").append(boxHtml);
//            };
            // 得到回复的评论的id
            this.getCommentFId = function () {
                return parseInt(fCode);
            };

            // 设置评论成功之后的内容
//            this.setCommentAfter = function (param) {
//                // 1.移除之前的取消回复按钮
//                $(self).find(".cancel").remove();
//                // 2.添加新评论的内容
//                //self.addNewComment(param);
//                // 3.让评论框处于对文章评论的状态
//                self.removeAllCommentFrom();
//                // 4.添加根下的回复框
//                self.addRootCommentFrom();
//            };

            // 添加新评论的内容
            //this.addNewComment = function (param) {
//                var topStyle = "";
//                if (parseInt(fCode) != 0) {
//                    topStyle = "topStyle";
//                }

//                var item = '';
//                item += '<div id="comment-lw' + v.id + '" class="comment-lw">';
//                item += '<div class="comment-main">';
//                item += '	<a class="user-logo">';
//                item += '		<img src="images/bloglogo.png">';
//                item += '	</a>';
//                item += '	<div class="comment-content">';
//                item += '		<div class="comment-info">';
//                item += '			<a> ' + v.nickName + ' </a>';
//                item += '			<span>' + v.createTime + ' </span>';
//                item += '		</div>';
//                item += '		<div class="comment-text"> ' + v.content + ' </div>';
//                item += '		<div class="comment-action">';
//                item += '			<a class="reply" href="javascript:void(0)" selfID="' + v.id +'" >回复</a>';
//                item += '		</div>';
//                item += '	</div>';
//                item += '</div>';
//                item += '</div>';
//
//                if (parseInt(fCode) == 0) { // 如果对根添加
//                    $("#commentItems").append(item);
//                } else {
//                    // 判断父级评论下是不是已经有了子级评论
//                    if ($("#comment-lw" + fCode).find(".comments-lw").length == 0) { // 没有
//                        var comments = '';
//                        comments += '<div id="comments-lw' + fCode + '" class="comments-lw">';
//                        comments += item;
//                        comments += '</div>';
//
//                        $("#comment-lw" + fCode).append(comments);
//                    } else { // 有
//                        $("#comments-lw" + fCode).append(item);
//                    }
//                }
//            };


            // 初始化上传控制层插件
            this.init();
        });
    };
})(jQuery);