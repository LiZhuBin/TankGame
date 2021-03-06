# TankGame
>**基于面向对象的双人坦克大战**

![Binary Tree](./display/main.png "Binary Tree")

**一、游戏规则**
    1、有图形界面，默认宽900，高800，位置（0,0），（可在Util中的常量Constant中修改）;
    2、有坦克1、坦克2、子弹1、子弹2、普通墙、硬墙等元素；
    3、有提示语：① 坦克1键盘方向键移动，SPACE发炮；② 坦克2键盘A S W D键移动，F发炮；
    4、有时间计时，从加载界面开始计时，以秒为单位；
    5、坦克1可以发射子弹1，坦克2可以发射子弹2，两个坦克可以自由移动、发炮，互不影响；
    6、坦克可以向上下左右移，不能穿过界面、墙和另一个坦克，但用子弹击打到后可以通过；
    7、子弹可穿过普通墙，不能穿过硬墙和坦克；
    8、子弹打到坦克，坦克会有爆炸，出现提示语显示坦克胜利和所用时间。

**二、包**

        ①game.util（工具包）
        ②tank(主要程包)
        ③images.tankImages1(坦克1上下左右图片包）
        ④images.tankImages2(坦克2上下左右图片包）
        ⑤images.bullets(子弹1、子弹2图片包）
        ⑥images.walls(普通墙、硬墙图片包）
        ⑦images(背景图片包)、⑧images.blasts(爆炸图片包）

**三、类**

       ①MyFrame类:继承Frame类:加载界面、消除闪烁；
       ②Util类;把String类型的路径path转化为Image类型
       ③GameObject类：物品类，包含物品的基本属性：位置(x,y)、大小(height、width)、       		     生命(live)、方向（direction)、速度(speed);
       ④Tank类：父类坦克的基本属性，实现坦克绘画(draw)、坦克爆炸（blast)、坦克移动			（move)等功能；
       ⑤Tank1、Tank2类：继承Tank类：实现键盘键控制坦克的移动；
       ⑥Bullet类：实现子弹绘画(draw)；
       ⑦Wall类：可根据传入位置，画出相应的墙；
       ⑧KeyMonitor类：用于坦克键盘事件；
       ⑨TankGameFrame类：实现绘画坦克、子弹、墙等物体，实现检验物体间是否碰撞并添			加事件，实现窗口绘画字符等功能；
       ⑩ Constant类：记录了游戏所需的全局常量，如窗口、坦克、子弹、墙的大小、			位置等。
