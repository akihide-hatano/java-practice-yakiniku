# yakiniku-app

## 概要
焼肉チェーン店を題材に、Javaでオブジェクト指向と責務分離を意識して作成した練習用アプリです。  
グループ共通メニュー、店舗情報、店舗追加などを model / service / app に分けて管理しています。

---

## 学習目的
- Javaのクラス設計に慣れる
- model / service / app の責務分離を意識する
- 配列を使ったデータ管理に慣れる
- Maven / JUnit を使った基本的な開発フローを学ぶ

---

## ディレクトリ構成
```
src
├── main
│   └── java
│       ├── app         # 実行クラス
│       ├── model       # データ保持クラス
│       ├── service     # 業務ロジック
│       └── repository  # DBアクセス層
└── test
    └── java
        └── service     # テストコード
```

## 設計

### app
アプリケーションの実行クラス。
全体の処理の流れを確認する役割。

### model
データを保持するクラス群。
- MenuItem：メニュー名、価格を保持
- Restaurant：店舗情報、店舗独自メニューを保持
- YakinikuyaGroup：グループ名、店舗一覧、共通メニューを管理

### service
modelを操作する処理クラス。
- MenuService：メニューの追加・管理
- RestaurantService：店舗関連の処理
- GroupService：グループ管理処理

---

## 責務分離

- model：データを保持する
- service：データを使って処理する
- app：実行して動作確認する

データと処理を分離することで、クラスごとの役割を明確にしています。

---

## テスト
```
JUnitを用いてテストコードを作成しています。

現在は以下を検証しています：

- 正常系：メニューが正しく追加されること
- 異常系：null / 空文字 / price <= 0 の場合に例外が発生すること
- 境界値：price = 1、最大件数（10件）時の挙動

サービスの契約（例外設計）を保証する形でテストを記述しています。
```
---

## 開発環境

- Java 21
- Maven
- JUnit 5
- VSCode
- MySQL

---

## 今後やりたいこと

- Repositoryのinterface化（DI対応）
- User以外（Menu / Restaurant）のDB永続化
- Service層の責務整理（ユースケース単位へ）
- エラーコード設計
- ログ設計（ユーザー向けと開発者向けの分離）
- Spring Bootへの移行

---

## 今後の設計方針（Spring Bootを意識）

現在はCLIアプリとして実装していますが、
将来的にWebアプリへ移行できる設計を意識しています。
