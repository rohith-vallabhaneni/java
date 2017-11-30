# platform_cdc_javaProvider1

| Description    | Value |
| -------------- | ----- |
| Date Generated | Fri Nov 10 12:51:21 UTC 2017 |
| Pact Version   | 3.5.4 |

## Verifying a pact between _platform_cdc_javaConsumer_ and _platform_cdc_javaProvider1_

Given **test state**  
ExampleJavaConsumerPactTest test interaction  
&nbsp;&nbsp;returns a response which  
&nbsp;&nbsp;&nbsp;&nbsp;has status code **200** (<span style='color:green'>OK</span>)  
&nbsp;&nbsp;&nbsp;&nbsp;includes headers  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"**Content-Type**" with value "**application/json; charset=UTF-8**" (<span style='color:green'>OK</span>)  
&nbsp;&nbsp;&nbsp;&nbsp;has a matching body (<span style='color:red'>FAILED</span>)  

| Path | Failure |
| ---- | ------- |
|$.password|Expected 'micel' but received 'michel'|

Diff:

```diff
{
-    "password": "micel",
-    "userName": "michel"
+    "userName": "michel",
+    "password": "michel"
}
```

