# 使用方式
### gradle
root build.gradle<br>
<pre class=" kode language-css"><code class=" kode language-css">	<span class="token selector">allprojects </span><span class="token punctuation">{</span>
		<span class="token selector">repositories </span><span class="token punctuation">{</span>
			<span class="token selector">...
			maven </span><span class="token punctuation">{</span> url <span class="token string">'https://jitpack.io'</span> <span class="token punctuation">}</span>
		<span class="token punctuation">}</span>
	<span class="token punctuation">}</span></code></pre><br>
model build.gradle<br>
<code id="depCodeGradle" class=" kode  language-css">	<span class="token selector">dependencies </span><span class="token punctuation">{</span>
	        compile <span class="token string">'com.github.wuxinxi:XBTool:1.1.1'</span>
	<span class="token punctuation">}</span>
</code>
### 
