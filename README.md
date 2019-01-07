# 概要

WannaTagサーバサイド

# プロジェクト構成

オニオンアーキテクチャをイメージ

```
- com.tiloom6
  - domain // ドメイン層
    - model // ドメインオブジェクト
    - service // ドメインモデルのロジック
    - repository // infrastructure層のinterface定義
  - infrastructure // infrastructure層
  - presentation // presentation層（UI）
  - serivce // ApplicationService層
```

参考：https://qiita.com/nanamen/items/f37d1047368929e377fd

# DDDのサンプル

https://github.com/j5ik2o/spetstore