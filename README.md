# クソ鍵BAN規制連発のクソ5chは専ブラ連合の協力によって崩壊し、Talkという新しい掲示板ができたので、こんなものはもう不要！🎉🎉🎉役割を終えたので㊗アーカイブ化しました！🎉🎉🎉🎉
# monakey-remover-app
毎日のようにmateを再インストールして設定をやり直していて疲れた方へ！  
再インストールやデータ消去をすることなくChMateの鍵無効を解除ようになる方法です。  
あるアプリを全く異なる別のアプリで上書きするという斬新な鍵削除法です。

これを導入すると、ChMateのデータを削除することなく、鍵削除用APKの上書きインストールで鍵だけを削除できます。 
mate本体の改造は一切不要なので、初心者でも比較的簡単なアプローチになっています。  
root化不要、PC不要、環境構築不要、知識不要。

<sub>注意: この方法は超初心者用です。詳しい人はTsubon○futaの方が楽です。</sub>

## 概要
mateを再署名して、同じパッケージ名の別アプリでmateを上書きします。
そうすれば、上書きしたアプリでmateの内部のアプリデータを自由に触れるようになります。

これを利用して、mateのアプリデータ領域に格納されている鍵(MonaKey)だけを消去します。

<img src="https://user-images.githubusercontent.com/90122968/189396124-af37b6de-9856-4cc2-bf39-2082efff2ccf.png" width="200px">

## 事前準備～実際の使用方法を簡単にまとめると…
1. 再署名されたChMateをインストールする
2. 鍵削除アプリのapkをダウンロードしておく
3. 以降は鍵無効を食らったら、鍵削除アプリのapkをインストールして鍵を削除し、再署名版mateのapkをインストールしてmateに戻せばOK

詳しい手順は以下

## 事前準備
### 1. 再署名されたChMateをインストールする
まず、今お使いのChMate(元の署名)はアンインストールする必要があります(署名が違うため)。バックアップを取ってアンインストールしてください。

次に、私kitadai31によってkitadai31の署名鍵で再署名されたChMateをインストールします。

[ChMate0.8.10.153_resigned_kitadai31.apk](https://raw.githubusercontent.com/kitadai31/kitadai31/main/ChMate0.8.10.153_resigned_kitadai31.apk)

~~[ChMate0.8.10.154_resigned_kitadai31.apk](https://raw.githubusercontent.com/kitadai31/kitadai31/main/ChMate0.8.10.154_resigned_kitadai31.apk)~~  
~~[ChMate0.8.10.158_resigned_kitadai31.apk](https://raw.githubusercontent.com/kitadai31/kitadai31/main/ChMate0.8.10.158_resigned_kitadai31.apk)~~  
<sub>154以降は再署名すると起動しないという報告がありました。  
私の環境では再署名してなくても起動しないので、何も確かめられませんが……  
もし動いた人がいたらぜひ報告お願いします。</sub>

### 2. 鍵削除アプリをダウンロード

[Releases](https://github.com/kitadai31/monakey-remover-app/releases)ページから `monakey-remover-app-for-mateXXX.apk` をダウンロードしておきます。

これで準備は完了です。

## 使い方
以後は、鍵を焼かれてしまったら、ChMateを終了し、`monakey-remover-app-for-mateXXX.apk`(鍵削除アプリ) をインストールします。  
(既存のアプリのアップデートと表示されます。)

すると、ChMateが鍵アイコンのアプリに置き換わるので、起動します。

![Screenshot_20220823-225738_compress](https://user-images.githubusercontent.com/90122968/186873447-91f7876f-7f6e-4d51-9370-d2aadb7c001d.jpg)

削除ボタンを押したら、鍵の削除は完了です。

そしたら、元の `ChMate0.8.10.XXX_resigned_kitadai31.apk`(再署名されたChMate) を上書きインストールします。  
これで、鍵削除アプリがChMateに戻ります。

鍵削除の手順は以上です。

![Screenshot_20220824-011443-1-compress](https://user-images.githubusercontent.com/90122968/186214335-5ec6543a-5f34-4cdb-9e71-1d4cefdb4469.png)  
2つのapkを分かりやすい場所にこんな感じで一緒に保存しておくと使いやすいでしょう。

## 仕組み
Androidでは、「同じパッケージ名」で「同じ署名」で「同じバージョンコード」のアプリなら相互に自由に何度でも上書きインストール(アップデート扱い)できます。  
これを利用することで、ChMateと「同じパッケージ名」で「同じバージョンコード」の鍵削除アプリを作成し、それと「同じ署名」でChMateを再署名することで、データを維持しつつ2つのアプリを自由に入れ替えられる状態を作れます。

ChMateでdev版の0.8.10.153とplay版の0.8.10.153が相互に上書きされちゃうのと同じ原理です。

ChMateのMonaKeyはアプリデータ領域の中に保存されているのでrootなしではどうあがいても他のアプリから消すことができませんが、この手法でChMateそのものをMonaKey削除アプリで上書きしてしまえば、アプリデータを読み書きできるのでMonaKeyを消すことができます。

<details>
<summary>「バージョンコード」「署名」とは</summary>

「バージョンコード」とは、アプリの絶対的なバーションを表す数字です。  
例えば、ChMate 0.8.10.153のバージョンコードは 417 です。  
Androidでは、このバージョンコードを見てアプリのアップデートをチェックしたり、アプリの上書きダウングレードを防止したりしています。  
このバージョンコードは、今インストールされてるAPKとバージョンコードが「同じ」である別のAPKがある場合、お互いに何度でも自由に上書きインストールできます。  
ChMateでDev版とPlay版のバージョンが同じだと、Dev版を使っているのにも関わらずいつの間にかPlayストアで更新されてPlay版に変わってしまうあるあるがありますが、それはこれが原因だったりします。  
これを利用しています。

「署名」はアプリの作成者を証明するものです。  
署名が同じならアプリを上書きアップデートできますが、署名が異なると、たとえパッケージ名が同じであろうと別アプリ扱いになり、上書きアップデートはできません。  
(これによって、悪意のある人物が偽物の新バージョンを作成して配布し上書きアップデートさせることなどを防いでいます。)  
なので、本物の署名のmateは、第三者(わたし)が勝手にパッケージ名を被せて作った別アプリ(鍵削除アプリ)で上書きすることができません。
mateを再署名する必要があるのはこのためです。

しかし、逆に署名が同じであれば上書きできます。

このことから、kitadai31の署名で再署名したバーション417のChMate (パッケージ名: jp.co.airfront.android.a2chMate) と、kitadai31が署名したバーション417の鍵削除アプリ (パッケージ名: jp.co.airfront.android.a2chMate) を用意すれば、相互に上書きインストールできるようになります。
</details>

## 質問
- ChMateのアップデートが来たらどうなりますか？
  - ChMateは、再署名しているため普通にはアプデできません。
  - データを残したままアップデートするには、私がそのバージョンの再署名mateをここに載せるまで待つか、もしくは自分で新バージョンのmateのapkを用意して同じ署名鍵で再署名する必要があります。(署名鍵は配布しています)
  - また、鍵削除アプリも新バージョンのバージョンコードに合わせてビルドしないと使えません。
  - 新しいバージョンが出たらなるべく早く公開しようと思います。
- 元のChMateに戻すには？
  - 再署名ChMateをアンインストールし、公式署名のmateをストアやDeployGateから再インストールしてください。
- これ広めてもいいんですか？
  - まず、広めれば広めるほどクソ運営は苦しみます。  
  スクリプト荒らしは元からもっと高度な方法で鍵を切り替えているのでこんなものは使いません。  
  mate作者は不利益を被りません。  
  よってこれは広めていいものでしょう。
  - そもそも悪いのは運営です。  
  UAと回線という絶対巻き添えが発生する規制方法を使っておきながら、もし巻き添えに引っかかったら全板BANというのはおかしな話です。  
  何も悪くない人が、うっかり巻き添え規制中の板に書き込んでしまっただけで全板でBANされるのは間違っています。  
  鍵をBANするのではく、当該板のみの規制にとどめておくべきだと私は思います。  
  (逆に、NGワードなどの巻き添えでない規制ならその人をピンポイントにBANするのは有効でしょう。)
- 安全ですか？
  - ChMateの再署名は、単にapksignerで上書きしただけです。最も安全なやり方だと思います。中身は一切手を加えていません。
  - (昔のjarsignerだと署名を消してからじゃないと再署名できなかったが、今のapksignerでは上から直接再署名が可能。)
  - 安全性が気になれば、apkを解凍してファイル比較ソフトで比較するか、mateの再署名と鍵削除アプリのソースコードのビルドを自前で行えばよいでしょう。
- いちいちapkを上書きするのが面倒。Cookie削除ボタンとかで消せないか？
  - Tsubonofuta様を使いましょう。なんと非rootでも使えるらしいです。
  - 他には、玉葱と呼ばれるものもあるらしいです。詳しくは分かりませんが。
- Tsubonofutaは使えないけど、もう少し簡単にしたい
  - https://github.com/kitadai31/monakey-remover
- root環境の人は？
  - この方法は非root向けです。rootの方は、/data/data/内のmateのデータの2chapi.xmlを直接編集するなりXposedでTsubonofutaさんを使うなりすればいいと思います。
- APKをインストールしようとするとPlayプロテクトの警告が出てインストールされないのですが。
  - 作りたての署名鍵を使うとPlayプロテクトに警告されるようです。「OK」ではなくその左の「インストールする」を押せば警告を無視してインストールできます。
  - インストール後に「この未知のアプリを送信しますか？」みたいな画面が出たら根気よく送信していくことで、そのうちGoogleに認知されて警告が出なくなるようです。 
  (追記 2022/12現在もう警告が出なくなりました。やはり送信をするのが大切なようです)

## 注意事項
再署名されたChMateを使うので、PlayストアやDeployGateで更新できなくなります。別署名のmateを入れるにはアンインストールが必要です。それを理解した上でお使いください。  
一応私が使っている署名鍵(jks)はソースに置いてあります。パスワードは000000

また、あるアプリを全く異なるアプリで上書きする、という通常ではありえないことをやるので、思わぬ不具合が発生する可能性がゼロではありません。  
データのバックアップは取っておきましょう。  
この手法を用いたことによって発生したいかなる損害も責任を負いません。  
もし何らかの不都合が起こったら教えてください。

**なお、いくら鍵(MonaKey)を消したところで、規制されている板に当該の回線や専ブラで書き込めばまたすぐに鍵がBANされるだけなので、鍵BANの根本的な回避にはなりません（重要）。**

## お知らせ
・2022/08/30  
いちいち削除ボタンを押す必要がない「nowindow」版を追加しました。  
nowindow版では、アプリを起動すると画面を表示することなくMonaKeyの削除だけを行い即座に終了します。(一瞬だけ画面が表示されることがありますが仕様です。)  
これを使うと、ファイラーからapkを上書きインストールしたら完了画面で「開く」を押せばその場ですぐにMonaKeyが削除されるので、あとはそのままファイラーから続けてChMateのapkを入れれば爆速でBANから復帰できます。

・2022/08/30 (2)  
Android6\~9でapkを上書きするたびに毎回ストレージ権限のダイアログが出てしまっている方は、対策したので今ある鍵削除apkを削除してreleasesからダウンロードし直してください。
