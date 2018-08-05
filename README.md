## y-zxing

#### 1. 简介

这是一个基于Google zxing的二维码/条形码的功能库，主要涉及到一些常用的二维码/条形码场景功能，主要功能包括：

- **棉花糖及以上运行时权限**
- **扫描二维码/条形码读取其中信息**
- **读取相册中的二维码/条形码图片读取其中信息**
- **打开和关闭手电筒**
- **仿微信绿色系UI**

#### 2. 实际运行效果图

|![1](https://s1.ax1x.com/2018/08/06/PDx4UA.png) | ![2](https://s1.ax1x.com/2018/08/06/PDx7gf.png) | ![3](https://s1.ax1x.com/2018/08/06/PDxHv8.png) |![4](https://s1.ax1x.com/2018/08/06/PDxqKS.png)|
| :---: | :---: | :---: |:---:|
| ![5](https://s1.ax1x.com/2018/08/06/PDxLDg.png) | ![6](https://s1.ax1x.com/2018/08/06/PDxjEj.png) | ![7](https://s1.ax1x.com/2018/08/06/PDxx5n.png) ||

#### 3. 代码调用

- 开启扫描二维码/条形码

`
ScanManager.getInstance().openScan(MainFragment.this);
`

- 扫描后的回调(在onActivityResult中触发)

`
ScanManager.getInstance().onActivityResult(getContext(),
                requestCode,
                resultCode,
                data);
`

- 开启相册

`
AlbumManager.getInstance().openAlbum(MainFragment.this);
`

- 相册读取图片后的回调(在onActivityResult中触发)

`
AlbumManager.getInstance().onActivityResult(getContext(),
                requestCode,
                data);
`

---


__特别鸣谢及参考链接__

- [Google ZXing系列讲解(一)——导入AS](https://www.jianshu.com/p/85e0bdb8bd2c)
- [Google ZXing系列讲解(二)——生成WIFi二维码](https://www.jianshu.com/p/656d6f6f862e)
- [Google ZXing系列讲解(三)——ZXing 目录结构与主体流程](https://www.jianshu.com/p/de529919e4e9)
- [Google ZXing系列讲解(四)——ZXing 解决竖屏扫描问题](https://www.jianshu.com/p/b78a967e2ac7)
- [Google ZXing系列讲解(五)——ZXing 仿微信扫描UI](https://www.jianshu.com/p/cbc1239a9f6f)