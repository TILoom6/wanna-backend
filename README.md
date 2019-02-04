# 概要

WannaTagサーバサイド

# プロジェクト構成

オニオンアーキテクチャをイメージ

```
- com.tiloom6
  - domain // ドメイン層
  - infrastructure // infrastructure層
  - adapter // presentation層（UI）
    - infrastructure // infra層（domain repository impl）
    - interface // http routiong etc.
  - usecase // ApplicationService層
```

参考：https://qiita.com/nanamen/items/f37d1047368929e377fd

# DDDのサンプル

https://github.com/j5ik2o/akka-ddd-cqrs-es-example

# Dao Generator

https://github.com/septeni-original/sbt-dao-generator