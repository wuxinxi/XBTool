# 使用方式
Step1: root build.gradle<br>
allprojects {<br>
		repositories {<br>
			...<br>
			maven { url 'https://jitpack.io' }<br>
		}<br>
	}<br>
  Step2:model build.gradle<br>
  dependencies {<br>
	        compile 'com.github.wuxinxi:XBTool:1.1.1'<br>
	}<br>
