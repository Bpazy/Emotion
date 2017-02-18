Emotion
=======
监测某账号的微博情绪值。      
(比如我女朋友发微博了，我这就收到邮件，接着该点赞点赞，该评论评论，该买买买就买买买)
<div  align="center">    
  <img src="https://github.com/Bpazy/utils/blob/master/pic/emotion_01.png" width = "300" alt="preview" align=center />
</div>

首次运行会自动创建配置文件(emotion.json)和程序缓存(local.txt)，并会扫描一遍所有微博。        
>目前扫描微博调用的是[prprpr.me](prprpr.me)的微博RSS API, 感谢作者的无私奉献，但该API在最新一条微博的时间上有BUG，第一条微博的时间总是会自己跳动，所以后期本项目会改由自己写的微博RSS API。    

配置文件可自动更新，扫描频率`1次/min`。     
扫描微博频率`2次/min`。    

配置文件格式:    
```
{
  "uid": "0000000000", //被检测用户微博UID
  "filters": [ //过滤词，微博含有过滤词将不参与分析
    "转发"
  ],
  "threshold": 0, //阈值，负情绪阈值，为0则分析所有微博，并发送信息到邮箱
  "secretId": "Your secretId", //腾讯文智申请的secretID
  "secretKey": "Your secretKey", //腾讯文智申请的secretKey
  "emailHostName": "smtp.163.com",
  "emailPort": 465,
  "emailUserName": "YourUserName", //发送邮件的账号
  "emailPassword": "YourPassword", //发送邮件的账号的密码
  "emails": [
    "example@example.com" //接受邮件通知的账号
  ],
  "mobiles": [
    "12345678910" //接受短信通知的手机号码，开发中
  ]
}
```

### 构建
`gradlew fatJar` ，构建的包在`./build/libs/`下。    
### 运行
`java -jar ./build/libs/emotion-*.jar`
