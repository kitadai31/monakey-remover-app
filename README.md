# monakey-remover-app
再署名されたChMateに、同じ署名の鍵削除アプリ「monakey-remover-app」を上書きインストールすることで、ChMateのデータを消さずに鍵を削除する手法です。

同じパッケージ名で同じバージョンコードで同じ署名の「ChMate」と「鍵削除用アプリ」を用意することで、2つを互いに上書きインストール可能にして、APKを上書きインストールするだけで鍵を削除できるようにします。

(これはChMateでdev版の0.8.10.153とplay版の0.8.10.153が相互に入れ替え可能であるのと同じ原理です。)

[鍵削除アプリの動作イメージ.png](https://user-images.githubusercontent.com/90122968/183068963-abf71e3c-4b16-43e6-b9f4-616e92564b03.png)

## 事前準備～実際の使用法を3行で(tl;dr)
1. kitadai31再署名版のChMateをインストールする
2. 鍵削除アプリのapkをダウンロードしておく
3. あとは鍵無効を食らったら、鍵削除アプリのapkをインストールして鍵を削除し、再署名版ChMateのapkをインストールしてmateに戻せばOK

詳しい手順は以下

## 事前準備
まず、今お使いのChMate(元の署名)はアンインストールする必要があります。バックアップを取ってアンインストールしてください。

次に、私kitadai31によってkitadai31の署名鍵で再署名されたChMateをインストールします。

[ChMate0.8.10.153_resigned_kitadai31.apk](https://raw.githubusercontent.com/kitadai31/kitadai31/main/ChMate0.8.10.153_resigned_kitadai31.apk)

この時、Playプロテクトの警告が出たら「OK」***で は な く***その左の インストールする を押します。

そして、[Releases](https://github.com/kitadai31/monakey-remover-app/releases)ページから `monakey-remover-app-for-mate153.apk` をダウンロードしておきます。

これで準備は完了です。

## 使い方
以後は、鍵を削除したくなったら、ChMateを終了し、`monakey-remover-app-for-mate153.apk`(鍵削除アプリ) をインストールします。  
(既存アプリのアップデートと表示されます。)

すると、ChMateが鍵アイコンのアプリに置き換わるので、起動します。

![Screenshot_20220823-225738](https://user-images.githubusercontent.com/90122968/186178402-2f774f67-2931-46d8-8c9c-4034e895cb4f.png)

削除ボタンを押したら、鍵の削除は完了です。

そしたら、元の `ChMate0.8.10.153_resign_kitadai31.apk`(再署名版ChMate) を上書きインストールします。  
これで、鍵削除アプリがChMateに戻ります。

以上の手順で、mateのデータを維持したまま鍵を削除することができます。

![Screenshot_20220824-011443-1-compress](https://user-images.githubusercontent.com/90122968/186214335-5ec6543a-5f34-4cdb-9e71-1d4cefdb4469.png)  
こんな感じに2つのapkを保存しておくと使いやすいでしょう。

## 仕組み
Androidでは、「同じパッケージ名」で「同じ署名」で「同じバージョンコード」のアプリなら相互に自由に何度でも上書きインストール(アップデート扱い)できます。  
これを使って、ChMateと「同じパッケージ名」で「同じバージョンコード」の鍵削除アプリを作成し、それと「同じ署名」でChMateを再署名することで、データを維持しつつ2つのアプリを自由に入れ替えることができます。

<details>
<summary>詳しく知る</summary>

まず、Androidアプリには、「パッケージ名」「バージョンコード」「署名」という仕組みが存在します。
  
「パッケージ名」は、アプリごとに一意につけられた名前です。  
例えば、ChMateのパッケージ名は `jp.co.airfront.android.a2chMate` です。  
パッケージ名が同じアプリはすなわち同じアプリです。

「バージョンコード」は、アプリの絶対的なバーションを表す数字です。  
例えば、ChMate 0.8.10.153のバージョンコードは 417 です。

今インストールされてるAPKよりもバージョンが高いAPKをインストールすると、アプリを上書きでアップデートできます。  
今インストールされてるAPKよりもバージョンが低いAPKは、ダウングレードになってしまうため上書きインストールできません。  
また、今インストールされてるAPKとバージョンコードが「同じ」APKは、お互いに何度でも自由に上書きインストールできます。  
ChMateでDev版とPlay版のバージョンが同じだと、Dev版を使っているのにも関わらずいつの間にかPlayストアで更新されてPlay版に変わってしまうのはこれが原因だったりします。  
これを利用しています。

「署名」はアプリの作成者を証明するものです。  
一つのアプリは通常ずっと同じ署名鍵で署名し続けます。  
同じパッケージ名のアプリであっても、署名が異なると別アプリ扱いになり、上書きアップデートはできません。  
(これによって、悪意のある人物が別の署名鍵で署名した偽物のアプリを作成して配布し上書きアップデートさせることなどを防いでいます。Playストアの安全にも関わっています。)  
逆に言うと、同じ署名鍵で署名しているなら、自分が勝手に再署名したアプリでも上書きアップデートすることができます。  
これも利用しています。

これらを組み合わせると、kitadai31が再署名したバーション417のChMate (パッケージ名: jp.co.airfront.android.a2chMate) に、kitadai31が署名したバーション417の鍵削除アプリ (パッケージ名: jp.co.airfront.android.a2chMate) をお互いに上書きインストールできます。
</details>

## 質問
- APKをインストールしようとするとPlayプロテクトが出てインストールされないのですが。
  - 署名鍵が一般に出回っている本物のChMateと異なるために、Playプロテクトにより警告が表示されます。(普通に考えたら超危険な状況なので当たり前です)
  - インストール時にPlayプロテクトの警告が出たら、\[OK\] ***で は な く***その左の \[インストールする\] を押してください。
  - ちなみに私が以前使っていた署名鍵はしばらく使ってたら何度インストールしても警告が出なくなったので、「この未知のアプリを送信しますか？」みたいな画面が出たら根気よく送信していけばそのうちGoogleに認知されて警告が出なくなると思います。
- ChMateのアップデートが来たらどうなりますか？
  - 再署名されたmateはPlayストアやDeployGateでは更新できません（署名が異なるため）。そのため、新バージョンのmateのapkを用意し、同じ署名鍵で再署名しないとアップデートはできません。
  - また、鍵削除アプリも新バージョンのバージョンコードに合わせてビルドしないと使えません。(今ある鍵削除アプリは0.8.10.153(417)専用です)
  - 新しいバージョンが出たらなるべく早く公開しようと思います。
- 元のChMateに戻すには？
  - 再署名ChMateをアンインストールし、ストアやDeployGateから再インストールしてください。
- これ広めてもいいんですか？
  - まず、広めれば広めるほど運営は苦しみます。スクリプト荒らしは元からもっと高度な方法で鍵を切り替えているのでこんなものは使いません。mate作者は不利益を被りません。よってこれは広めていいものでしょう。
- いちいちapkをインストールするのが面倒。ChMateの中に組み込んだりできないか。
  - https://github.com/kitadai31/monakey-remover
- 安全ですか？
  - ChMateの再署名は単にzipコマンドで `zip -d hoge.apk "META-INF/*"` を実行してapkの署名を削除し、再びzipalignと署名をしただけです。最も安全なやり方だと思います。
  - 安全性が気になればこのコマンドで自前の鍵で再署名できます。鍵削除アプリの方はソースコードをビルドできます。

## 注意事項
再署名されたChMateを使うので、PlayストアやDeployGateで更新できなくなります。  
万が一私が消えた場合、データを維持したまま今後もアップデートするには kitadai31.jks でずっと再署名し続ける必要があります。

ちなみにいくら鍵を消したところで、規制中の板に当該の回線や専ブラで書き込めばまた鍵が無効化されるだけなので、鍵規制の根本的な回避にはなりません（重要）。

また、あるアプリを全く異なるアプリで上書きする、という通常ではありえないことをやるので、思わぬ不具合が発生するかもしれません。  
データのバックアップは必ず取っておいてください。  
自己責任でお願いします。この方法を使ったことにより損害があっても作成者は責任を負いません。  
何らかの不都合が起こったら教えていただけると助かります。
