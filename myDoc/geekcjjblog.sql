/*
 Navicat Premium Data Transfer

 Source Server         : myMac
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : geekcjjblog

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 03/10/2020 14:12:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment` (
  `id` char(44) NOT NULL,
  `user_id` char(44) DEFAULT NULL COMMENT '发表评论的用户ID',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `website` varchar(255) DEFAULT NULL COMMENT '个人网址',
  `to_user_id` char(44) DEFAULT NULL COMMENT '被评论的用户ID',
  `to_nick_name` varchar(255) DEFAULT NULL COMMENT '评论回复的人',
  `comment_content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `thumb_count` varchar(255) DEFAULT NULL COMMENT '点赞数量',
  `article_id` char(44) DEFAULT NULL COMMENT '文章ID',
  `article_type` varchar(255) DEFAULT NULL COMMENT '文章类型,与文章ID搭配使用,判断评论属于哪一种文章',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `comment_type` tinyint(1) DEFAULT NULL COMMENT '评论的类型,0为评论,1为评论的回复',
  `parent_id` char(44) DEFAULT NULL COMMENT '评论的父ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for articles_blog
-- ----------------------------
DROP TABLE IF EXISTS `articles_blog`;
CREATE TABLE `articles_blog` (
  `id` char(44) NOT NULL,
  `author_id` char(44) DEFAULT NULL COMMENT '发布文章的用户ID',
  `author_name` varchar(255) DEFAULT NULL COMMENT '作者名称',
  `author_pic` varchar(255) DEFAULT NULL COMMENT '作者头像',
  `original_author` varchar(255) DEFAULT NULL COMMENT '文章原作者',
  `title` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `description` varchar(255) DEFAULT NULL COMMENT '文章描述,用于在列表展示页的显示',
  `content` text COMMENT '文章内容',
  `content_url` varchar(255) DEFAULT NULL COMMENT '文章内容文件地址,留作之后升级用',
  `browse_count` bigint(20) DEFAULT NULL COMMENT '文章浏览量',
  `category_id` smallint(6) DEFAULT NULL COMMENT '文章种类（所属目录）',
  `tag_id` smallint(6) DEFAULT NULL COMMENT '文章内容的标签',
  `article_url` varchar(255) DEFAULT NULL COMMENT '文章链接地址',
  `likes` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `create_time` datetime DEFAULT NULL COMMENT '文章创建时间',
  `previous_article_id` char(44) DEFAULT NULL COMMENT '上一篇文章的ID',
  `next_article_id` char(44) DEFAULT NULL COMMENT '下一篇文章的ID',
  `article_img` varchar(255) DEFAULT NULL COMMENT '文章的摘要图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for articles_life
-- ----------------------------
DROP TABLE IF EXISTS `articles_life`;
CREATE TABLE `articles_life` (
  `id` char(44) NOT NULL,
  `author_id` char(44) DEFAULT NULL COMMENT '作者ID',
  `author_name` varchar(255) DEFAULT NULL COMMENT '作者名称',
  `author_pic` varchar(255) DEFAULT NULL COMMENT '作者头像',
  `title` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `description` varchar(255) DEFAULT NULL COMMENT '文章描述,用于在列表展示页的显示',
  `content` text COMMENT '文章内容',
  `content_url` varchar(255) DEFAULT NULL COMMENT '文章内容文件地址,留作之后升级用',
  `browse_count` bigint(20) DEFAULT NULL COMMENT '文章浏览量',
  `category_id` tinyint(4) DEFAULT NULL COMMENT '文章种类（文章所属目录）',
  `article_url` varchar(255) DEFAULT NULL COMMENT '文章链接地址',
  `likes` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `create_time` datetime DEFAULT NULL COMMENT '文章创建时间',
  `previous_article_id` char(44) DEFAULT NULL COMMENT '上一篇文章',
  `nezxt_article_id` char(44) DEFAULT NULL COMMENT '下一篇文章',
  `article_img` varchar(255) DEFAULT NULL COMMENT '文章摘要的图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for articles_new
-- ----------------------------
DROP TABLE IF EXISTS `articles_new`;
CREATE TABLE `articles_new` (
  `id` char(44) NOT NULL,
  `author_name` varchar(255) DEFAULT NULL COMMENT '作者名称',
  `original_author` varchar(255) DEFAULT NULL COMMENT '原作者',
  `title` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `description` varchar(255) DEFAULT NULL COMMENT '文章描述,用于在列表展示页的显示',
  `content` text COMMENT '文章内容',
  `content_url` varchar(255) DEFAULT NULL COMMENT '文章内容文件地址,留作之后升级用',
  `browse_count` bigint(20) DEFAULT NULL COMMENT '文章浏览量',
  `category_id` smallint(6) DEFAULT NULL COMMENT '文章种类',
  `article_url` varchar(255) DEFAULT NULL COMMENT '文章链接地址',
  `likes` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `create_time` datetime DEFAULT NULL COMMENT '文章创建时间',
  `previous_article_id` char(44) DEFAULT NULL COMMENT '上一篇文章ID',
  `next_article_id` char(44) DEFAULT NULL COMMENT '下一篇文章ID',
  `article_img` varchar(255) DEFAULT NULL COMMENT '文章摘要的图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `id` char(44) NOT NULL,
  `user_pic` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `username` varchar(255) DEFAULT NULL COMMENT '登录用户名,为展示在个人url里的ID,注册用户注册后,只给修改一次,为字母与数字的组合',
  `nickname` varchar(255) DEFAULT NULL COMMENT '显示给别人的昵称',
  `email` varchar(255) DEFAULT NULL COMMENT '个人信息中的邮箱',
  `phone` char(22) DEFAULT NULL COMMENT '个人信息中的手机号',
  `personalintroduction` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `personalizedsignature` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `myotherlink` varchar(255) DEFAULT NULL COMMENT '我的其他网站链接',
  `birth_time` date DEFAULT NULL COMMENT '出生日期',
  `user_gender` tinyint(4) DEFAULT NULL COMMENT '性别：0为女生，1为男生',
  `in_industry` varchar(255) DEFAULT NULL COMMENT '所在行业',
  `in_city` varchar(255) DEFAULT NULL COMMENT '所在城市',
  `is_admin` char(11) DEFAULT NULL COMMENT '判断是否为管理员：1为是，',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
BEGIN;
INSERT INTO `blog_user` VALUES ('1', '/images/mai.png', 'geekcjj', '梦极客园', 'xxx@xxx.xx', '13082540095', '我就是我！', '不一样的我！', '2020-01-17 05:07:27', 'http://www.xxx.xx', '1997-02-02', 1, '互联网', '南京', 'adminUser');
COMMIT;

-- ----------------------------
-- Table structure for blog_user_pwd
-- ----------------------------
DROP TABLE IF EXISTS `blog_user_pwd`;
CREATE TABLE `blog_user_pwd` (
  `id` char(44) NOT NULL,
  `blog_user_id` char(44) DEFAULT NULL COMMENT '博客用户ID',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_user_pwd
-- ----------------------------
BEGIN;
INSERT INTO `blog_user_pwd` VALUES ('1', '1', '123456');
COMMIT;

-- ----------------------------
-- Table structure for blog_user_role
-- ----------------------------
DROP TABLE IF EXISTS `blog_user_role`;
CREATE TABLE `blog_user_role` (
  `id` char(44) NOT NULL,
  `user_id` char(44) DEFAULT NULL COMMENT '用户ID',
  `role_id` tinyint(4) DEFAULT NULL COMMENT '用户角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` char(44) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `category_code` char(11) DEFAULT NULL COMMENT '分类代码',
  `category_type` varchar(255) DEFAULT NULL COMMENT '分类的类型：blog，life，new，resource',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES ('1', 'Java技术', 'java', 'blog');
INSERT INTO `category` VALUES ('10', 'Linux', 'linux', 'blog');
INSERT INTO `category` VALUES ('11', '技术教程', 'teach', 'blog');
INSERT INTO `category` VALUES ('12', 'PHP技术', 'php', 'blog');
INSERT INTO `category` VALUES ('13', 'Unity技术', 'unity', 'blog');
INSERT INTO `category` VALUES ('14', 'Python', 'python', 'blog');
INSERT INTO `category` VALUES ('15', '业内新技术', 'newtech', 'blog');
INSERT INTO `category` VALUES ('16', '格物生活', 'life', 'life');
INSERT INTO `category` VALUES ('17', '业内新闻', 'itnew', 'new');
INSERT INTO `category` VALUES ('18', '新闻资讯', 'new', 'new');
INSERT INTO `category` VALUES ('2', 'Spring技术', 'spring', 'blog');
INSERT INTO `category` VALUES ('3', 'Android技术', 'android', 'blog');
INSERT INTO `category` VALUES ('4', 'CSharp编程', 'csharp', 'blog');
INSERT INTO `category` VALUES ('5', '.Net技术', '.net', 'blog');
INSERT INTO `category` VALUES ('6', 'HTML&JS', 'htmljs', 'blog');
INSERT INTO `category` VALUES ('7', 'Vue技术', 'vue', 'blog');
INSERT INTO `category` VALUES ('8', '网络技术', 'network', 'blog');
INSERT INTO `category` VALUES ('9', 'C&C++', 'cpp', 'blog');
COMMIT;

-- ----------------------------
-- Table structure for friend_link
-- ----------------------------
DROP TABLE IF EXISTS `friend_link`;
CREATE TABLE `friend_link` (
  `id` char(44) NOT NULL,
  `link_name` varchar(255) DEFAULT NULL COMMENT '链接名称',
  `link_url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `link_type` char(22) DEFAULT NULL COMMENT '链接的分类',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend_link
-- ----------------------------
BEGIN;
INSERT INTO `friend_link` VALUES ('1', '梦极客园', 'http://www.xxx.xx', 'web', '2020-01-17 07:18:52');
INSERT INTO `friend_link` VALUES ('2', '小池塘', 'http://www.chitang.club', 'web', '2020-01-17 07:20:08');
INSERT INTO `friend_link` VALUES ('3', '麦壳千元科技', 'http://www.maikete.xyz', 'com', '2020-01-17 07:20:53');
COMMIT;

-- ----------------------------
-- Table structure for index_gallery
-- ----------------------------
DROP TABLE IF EXISTS `index_gallery`;
CREATE TABLE `index_gallery` (
  `id` char(44) NOT NULL,
  `slider_img` varchar(255) DEFAULT NULL COMMENT '滑动图片的url,不仅是图片也可以是视频等其他广告等图片资源',
  `img_description` varchar(255) DEFAULT NULL COMMENT '图片的描述',
  `img_link` varchar(255) DEFAULT NULL COMMENT '图片要链接饿地址,可以是网站内的一个url,也可以是外部网站的链接',
  `is_advertise` char(11) DEFAULT NULL COMMENT '是否是广告',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of index_gallery
-- ----------------------------
BEGIN;
INSERT INTO `index_gallery` VALUES ('1', 'http://localhost:8090/sourceFile/indexSliderPicture/11.jpg', '1111111111111', NULL, '0', '2020-01-17 07:21:27');
INSERT INTO `index_gallery` VALUES ('2', 'http://localhost:8090/sourceFile/indexSliderPicture/22.jpg', '2222222222', NULL, '0', '2020-01-17 07:21:47');
INSERT INTO `index_gallery` VALUES ('3', 'http://localhost:8090/sourceFile/indexSliderPicture/33.jpg', '3333333333', NULL, '0', '2020-01-17 07:22:09');
INSERT INTO `index_gallery` VALUES ('4', 'http://localhost:8090/sourceFile/indexSliderPicture/44.jpg', '444444444', NULL, '0', '2020-01-17 07:22:33');
COMMIT;

-- ----------------------------
-- Table structure for leave_words
-- ----------------------------
DROP TABLE IF EXISTS `leave_words`;
CREATE TABLE `leave_words` (
  `id` char(44) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL COMMENT '用户留言的昵称',
  `email` varchar(255) DEFAULT NULL COMMENT '用户的邮箱',
  `website` varchar(255) DEFAULT NULL COMMENT '用户的网址',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '用户留言的内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `lw_type` tinyint(4) DEFAULT NULL COMMENT '留言的类型,0为留言,1为留言的回复',
  `to_user_id` char(44) DEFAULT NULL COMMENT '留言的用户对象ID',
  `to_nick_name` varchar(255) DEFAULT NULL COMMENT '留言的用户对象昵称',
  `user_id` char(44) DEFAULT NULL COMMENT '发表评论或回复的用户ID',
  `parent_id` char(44) DEFAULT NULL COMMENT '留言的父ID',
  `user_pic` varchar(255) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leave_words
-- ----------------------------
BEGIN;
INSERT INTO `leave_words` VALUES ('2020011707264446000001', '陈晨辰', 'xxx@xxx.xx', 'http://www.xxx.xx', '<h2 id=\"使用javaxannotation的注解类\" style=\"outline: 0px; margin-top: 8px; margin-bottom: 16px; font-size: 24px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); font-weight: 700; line-height: 32px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures;\"><span style=\"outline: 0px; overflow-wrap: break-word;\">使用javax.annotation的注解类</span></h2><p style=\"outline: 0px; margin-bottom: 16px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; font-size: 16px; color: rgb(77, 77, 77); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures;\">javax.annotation.Resource 注解在eclipse中无法通过 ctrl + shift + O导入该注解类，是因为javax是属于扩展库中，需要手动下载，或者使用maven依赖如下：</p>', '2019-01-16 17:26:44', 0, NULL, NULL, NULL, '0', NULL);
INSERT INTO `leave_words` VALUES ('2020011707264446000002', 'ddd', 'sfsf@qwc.ocom', NULL, '是德国的根深蒂固说过的', '2020-01-17 18:41:27', 1, '', '陈晨辰', NULL, '2020011707264446000001', NULL);
INSERT INTO `leave_words` VALUES ('2020011707343786700001', 'Garry Chan', 'xxx@xxx.xx', '', '<p>1、@Autowired与@Resource都可以用来装配bean. 都可以写在字段上,或写在setter方法上。&nbsp;</p><p><br></p><p>2、@Autowired默认按类型装配（这个注解是属于spring的），默认情况下必须要求依赖对象必须存在，如果要允许null 值，可以设置它的required属性为false，如：@Autowired(required=false) ，如果我们想使用名称装配可以结合@Qualifier注解进行使用，如下：&nbsp;</p><p>Java代码&nbsp; 收藏代码</p><p>@Autowired() @Qualifier(\"baseDao\")&nbsp; &nbsp; &nbsp;</p><p>private BaseDao baseDao;&nbsp; &nbsp;</p><p>&nbsp;</p><p>&nbsp;3、@Resource（这个注解属于J2EE的），默认安照名称进行装配，名称可以通过name属性进行指定，&nbsp;</p><p>如果没有指定name属性，当注解写在字段上时，默认取字段名进行按照名称查找，如果注解写在setter方法上默认取属性名进行装配。 当找不到与名称匹配的bean时才按照类型进行装配。但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。</p><p>Java代码&nbsp; 收藏代码</p><p>@Resource(name=\"baseDao\")&nbsp; &nbsp; &nbsp;</p><p>private BaseDao baseDao;&nbsp; &nbsp;&nbsp;</p><p>&nbsp;</p><p>推荐使用：@Resource注解在字段上，且这个注解是属于J2EE的，减少了与spring的耦合。最重要的这样代码看起就比较优雅。(要注意的是用jdk10版本在使用@Resource注解时装配失败，改用@Autowired() 和@Qualifier(\"baseDao\")后bean装配成功）</p><p><br></p>', '2020-01-01 17:34:38', 0, NULL, NULL, NULL, '0', NULL);
INSERT INTO `leave_words` VALUES ('2020011804104722600001', '都是根深蒂固说的', 'xxx@xxx.xx', '', '企鹅群我 i 就去问人家恩如图', '2020-01-17 14:10:47', 1, NULL, 'Garry Chan', NULL, '2020011707343786700001', NULL);
INSERT INTO `leave_words` VALUES ('2020011804472702300001', '董文', 'wrwr@wwe.com', '', '哎我去然后我日俄日 u 为', '2020-01-17 14:47:27', 1, NULL, 'ddd', NULL, '2020011707264446000002', NULL);
INSERT INTO `leave_words` VALUES ('2020011906163609000001', '大度', 'xxx@xxx.xx', '', '时代舒服的沙发水电费水电费舒服', '2020-01-19 06:16:36', 1, NULL, '陈晨辰', NULL, '2020011707264446000001', NULL);
INSERT INTO `leave_words` VALUES ('2020011906203081700001', '啊伟', 'sdfsdgsd@qw.com', '', '伟日吴芮问题我不归我能感觉到放开你的高科技', '2020-01-19 06:20:31', 1, NULL, '大度', NULL, '2020011906163609000001', NULL);
INSERT INTO `leave_words` VALUES ('2020011906290753300001', '雯雯', 'asfasf@qq.com', '', '我爱你！', '2020-01-19 06:29:08', 1, NULL, '大度', NULL, '2020011906163609000001', NULL);
INSERT INTO `leave_words` VALUES ('2020011906352596000001', '啊伟', 'xxx@xxx.xx', '', '我也爱你！', '2020-01-19 06:35:26', 1, NULL, '雯雯', NULL, '2020011906290753300001', NULL);
INSERT INTO `leave_words` VALUES ('2020012223555311300001', '江小鱼', 'jxy@qq.com', '', '我爱你🤟❤️是否 i 上电脑课', '2020-01-22 23:55:53', 1, NULL, 'Garry Chan', NULL, '2020011707343786700001', NULL);
COMMIT;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` char(44) NOT NULL,
  `user_id` char(44) DEFAULT NULL COMMENT '登录用户ID',
  `login_time` datetime DEFAULT NULL COMMENT '登录的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for resource_download
-- ----------------------------
DROP TABLE IF EXISTS `resource_download`;
CREATE TABLE `resource_download` (
  `id` char(44) NOT NULL,
  `up_user_id` char(44) DEFAULT NULL COMMENT '上传作者的ID',
  `up_author` varchar(255) DEFAULT NULL COMMENT '上传作者的昵称',
  `title` varchar(255) DEFAULT NULL COMMENT '资源的标题',
  `description` varchar(255) DEFAULT NULL COMMENT '资源的描述',
  `resource_add` varchar(255) DEFAULT NULL COMMENT '资源的链接地址',
  `create_time` datetime DEFAULT NULL COMMENT '资源上传的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` char(44) NOT NULL,
  `permission_name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `permission_url` varchar(255) DEFAULT NULL COMMENT '权限的地址（操作地址）',
  `permission_type` char(11) DEFAULT NULL COMMENT '权限的类型：button或menu',
  `permission_operate` char(22) DEFAULT NULL COMMENT '权限的操作：add，delete，select，alert',
  `parent_id` smallint(6) DEFAULT NULL COMMENT '权限父id,是button就为0,是menu就为自然数',
  `parent_child_id` smallint(6) DEFAULT NULL COMMENT '权限子id,是button为父id的值,是menu则为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` smallint(6) NOT NULL,
  `tag_name` varchar(255) DEFAULT NULL COMMENT '标签名称',
  `create_time` datetime DEFAULT NULL COMMENT '标签的创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------
BEGIN;
INSERT INTO `tags` VALUES (1, 'Java技术', '2020-01-17 04:33:01');
INSERT INTO `tags` VALUES (2, 'C#编程', '2020-01-17 04:34:28');
INSERT INTO `tags` VALUES (3, 'ASP.NET技术', '2020-01-17 04:34:33');
INSERT INTO `tags` VALUES (4, '生活', '2020-01-17 04:41:01');
INSERT INTO `tags` VALUES (5, '资讯', '2020-01-17 04:41:34');
INSERT INTO `tags` VALUES (6, 'Spring技术', '2020-01-17 04:41:50');
INSERT INTO `tags` VALUES (7, 'SpringBoot技术', '2020-01-17 04:42:23');
INSERT INTO `tags` VALUES (8, 'SpringCloud技术', '2020-01-17 04:42:45');
INSERT INTO `tags` VALUES (9, 'Maven相关', '2020-01-17 04:43:08');
INSERT INTO `tags` VALUES (10, 'H5', '2020-01-17 04:43:52');
INSERT INTO `tags` VALUES (11, 'Js&Jquery', '2020-01-17 04:44:53');
INSERT INTO `tags` VALUES (12, 'VUE技术', '2020-01-17 04:45:08');
INSERT INTO `tags` VALUES (13, '前端框架', '2020-01-17 04:45:42');
INSERT INTO `tags` VALUES (14, 'Android', '2020-01-17 04:47:21');
INSERT INTO `tags` VALUES (15, 'PHP', '2020-01-17 04:48:26');
INSERT INTO `tags` VALUES (16, '网络技术', '2020-01-17 04:48:31');
INSERT INTO `tags` VALUES (17, '单片机相关', '2020-01-17 04:50:07');
INSERT INTO `tags` VALUES (18, '网络资源', '2020-01-17 04:50:09');
INSERT INTO `tags` VALUES (19, 'IT业内', '2020-01-17 04:51:56');
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` tinyint(4) NOT NULL,
  `role_code` char(11) DEFAULT NULL COMMENT '角色代码',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_description` varchar(255) DEFAULT NULL COMMENT '角色简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `user_role_permission`;
CREATE TABLE `user_role_permission` (
  `id` char(44) NOT NULL,
  `user_role_id` tinyint(4) DEFAULT NULL COMMENT '用户角色表的ID',
  `role_permission_id` char(44) DEFAULT NULL COMMENT '用户角色权限表的ID',
  PRIMARY KEY (`id`),
  KEY `user_role_foreignkey` (`user_role_id`),
  KEY `user_role_per_foreginkey` (`role_permission_id`),
  CONSTRAINT `user_role_foreignkey` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE CASCADE,
  CONSTRAINT `user_role_per_foreginkey` FOREIGN KEY (`role_permission_id`) REFERENCES `role_permission` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for web_info
-- ----------------------------
DROP TABLE IF EXISTS `web_info`;
CREATE TABLE `web_info` (
  `id` tinyint(11) DEFAULT NULL,
  `web_name` varchar(44) DEFAULT NULL,
  `web_description` varchar(200) DEFAULT NULL,
  `web_founder` char(44) DEFAULT NULL,
  `web_info` varchar(200) DEFAULT NULL,
  `web_copyright` char(44) DEFAULT NULL,
  `web_portal` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
