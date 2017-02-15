Emotion
=======
检测女朋友(任何人)的微博情绪值。


配置文件格式:
```
{
  "uid": "0000000000", //被检测用户微博UID
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