# 使用方式
Step1: root build.gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  Step2:model build.gradle
  dependencies {
	        compile 'com.github.wuxinxi:XBTool:1.1.1'
	}
