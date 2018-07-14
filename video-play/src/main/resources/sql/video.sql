drop table if EXISTS video_group;
create table video_group (
  id int primary key not  null auto_increment,
	group_name varchar(32) UNIQUE comment '分组名称',
	group_detail varchar(128) comment '分组描述'
);

/*视频信息*/
drop table if EXISTS video_info;
create table video_info (
	id int primary key not null auto_increment,
	video_name varchar(128) not null comment '视频名称',
	video_url varchar(64) not null comment '视频地址',
	group_id int not null comment '视频分组',
	video_type varchar(16) not null comment '视频类型 .mp4等',
	video_img varchar(64) not null comment '视频截图地址',
	video_produce varchar(256) comment '视频简介',
	play_num BIGINT comment '播放次数',
  data_version BIGINT default 0 comment '数据版本',
	delete_flag SMALLINT not null default 0 comment '删除标识 0未删除 1 已删除'
);

/*视频播放历史*/
drop table if EXISTS history_video;
create table history_video(
	id int primary key not null auto_increment,
	user_id int not null comment '用户ID',
	video_id int not null UNIQUE comment '视频ID',
	play_time varchar(16) not null comment '上次播放时间',
	total_time BIGINT comment '视频播放总时间',
	start_time datetime comment '此次开始观看时间，用作计算此次观看时长计算',
	delete_flag SMALLINT not null default 0 comment '删除标识 0未删除 1 已删除'
);

drop table if EXISTS video_user;
create table video_user(
	id int primary key not null auto_increment,
	user_name varchar(16) not null comment '用户名'
);
