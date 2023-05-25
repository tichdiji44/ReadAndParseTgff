# ReadAndParseTgff

## 描述（Description)

解析TGFF文件，使之变成可以运行的java类，用户可以根据获取的java类再进行二次封装等操作。

## 用法(Usage)

运行`ReadTgff.java`中的main函数，如需自己指定TGFF文件地址，请修改main函数中`readTgff()`的参数即可。

## 参考（Reference)

[https://github.com/dliul/tgff2json](https://github.com/dliul/tgff2json)

上述项目仅考虑TGFF中只有一个任务时的情况，然而在进行批量生成任务时，TGFF中可能有不止一种情况，因此对所参考的项目进行改进，以使项目可以解析多任务情况的TGFF文件。

