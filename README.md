# 使用方式
### gradle
root build.gradle<br>
<pre class=" kode language-css"><code class=" kode language-css">	<span class="token selector">allprojects </span><span class="token punctuation">{</span>
		<span class="token selector">repositories </span><span class="token punctuation">{</span>
			<span class="token selector">...
			maven </span><span class="token punctuation">{</span> url <span class="token string">'https://jitpack.io'</span> <span class="token punctuation">}</span>
		<span class="token punctuation">}</span>
	<span class="token punctuation">}</span></code></pre>
model build.gradle<br>
<pre class=" kode  language-css"><code id="depCodeGradle" class=" kode  language-css">	<span class="token selector">dependencies </span><span class="token punctuation">{</span>
	        compile <span class="token string">'com.github.wuxinxi:XBTool:1.1.1'</span>
	<span class="token punctuation">}</span>
</code></pre>
### Maven
Add the JitPack repository to your build file<br>
<pre class=" kode language-markup"><code class=" kode language-markup">	<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>repositories</span><span class="token punctuation">&gt;</span></span>
		<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>repository</span><span class="token punctuation">&gt;</span></span>
		    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span><span class="token punctuation">&gt;</span></span>jitpack.io<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">&gt;</span></span>
		    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>url</span><span class="token punctuation">&gt;</span></span>https://jitpack.io<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>url</span><span class="token punctuation">&gt;</span></span>
		<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>repository</span><span class="token punctuation">&gt;</span></span>
	<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>repositories</span><span class="token punctuation">&gt;</span></span></code></pre>
	 Add the dependency<br><pre class=" kode  language-markup"><code id="depCode" class="kode  language-markup">	<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">&gt;</span></span>
	    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">&gt;</span></span>com.github.wuxinxi<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">&gt;</span></span>
	    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">&gt;</span></span>XBTool<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">&gt;</span></span>
	    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">&gt;</span></span>1.1.1<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">&gt;</span></span>
	<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">&gt;</span></span>
</code></pre>
</code>
