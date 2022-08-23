# monakey-remover-app
ChMateのデータを削除することなく、APKの上書きインストールだけで鍵を削除します。  

これはChMateに上書きインストールする鍵削除アプリです。  
ChMateを再署名し、鍵削除用アプリと同じ署名で署名することで、互いに上書きインストール可能にしてAPKのインストールだけで鍵を削除できるようにします。  

# 最初の手順
まず、今お使いのChMateはアンインストールする必要があります。バックアップを取ってアンインストールしてください。  
次に、私kitadai31がkitadai31の署名鍵で再署名したChMateをインストールします。  
この時、Playプロテクトの警告が出たら「OK」***ではなく***その左の インストールする を押します。  
これで準備は完了です。

# 使い方
鍵を削除したくなったら、ChMateを終了し、`monakey-remover-app-for-ChMate0.8.10.153.apk`(鍵削除アプリ) をインストールします。(既存アプリのアップデート扱いになります。)

すると、ChMateが黄緑色の鍵アイコンの鍵削除アプリに置き換わります。

![Screenshot_20220823-225738](https://user-images.githubusercontent.com/90122968/186178402-2f774f67-2931-46d8-8c9c-4034e895cb4f.png)

アプリを起動し、説 明 を 読 ん で か ら 削除ボタンを押します。  
これで鍵の削除は完了です。

そしたら、元の `ChMate0.8.10.153_resign_kitadai31.apk`(再署名版ChMate) を上書きインストールします。
これによって、鍵削除アプリが元のChMateに戻ります。

以上で、データを維持したまま鍵を削除することができます。

# 仕組み
まず、Androidアプリには、「パッケージ名」「バージョンコード」「署名」という仕組みが存在します。

<details>
<summary>詳細</summary>
「パッケージ名」は、アプリごとに一意につけられた名前です。  
例えば、ChMateのパッケージ名は `jp.co.airfront.android.a2chMate` です。  
パッケージ名が同じアプリはすなわち同じアプリです。

「バージョンコード」は、アプリの絶対的なバーションを表す数字です。  
例えば、ChMate 0.8.10.153のバージョンコードは 417 です。
今インストールされてるAPKよりもバージョンコードが高いAPKをインストールすると、アプリをアップデートできます。
今インストールされてるAPKよりもバージョンコードが低いAPKは、ダウングレードになってしまうためインストールできません。

今インストールされてるAPKとバージョンコードが「同じ」APKは、何度でも自由にインストールできます。  
ChMateで、Dev版とPlay版のバージョンが同じだとDev版を使っていたのにも関わらずいつの間にかPlayストアで更新されてPlay版に変わってしまうのはこれが原因だったりします。  
これを利用しています。

「署名」はアプリの作成者を証明するものです。  
一つのアプリは通常ずっと同じ署名鍵で署名し続けます。  
同じアプリであっても、署名が異なると別アプリ扱いになり、上書きアップデートはできません。  
これによって、悪意のある人物が別の署名鍵で署名した偽物のアプリを作成して配布し上書きアップデートさせることなどを防ぎます。  
逆に言うと、同じ署名鍵で署名し続ければ、自分が勝手に再署名したアプリでも上書きアップデートすることができます。  
これも利用しています。
</details>

このことから、「同じパッケージ名」で「同じバージョンコード」で「同じ署名」のAPKなら何度でも自由に相互的に上書きインストール(アップデート扱い)できます。  
これを利用すると、kitadai31の署名で再署名したバーション417のChMateに、kitadai31が最初から署名しているバーション417の鍵削除アプリを上書きインストールできます。  
アップデート扱いなのでデータを維持することができます。

# 注意事項
APKのインストール時にPlayプロテクトの警告が出たら、[OK] ***ではなく***その左の インストールする を押してください。

あるアプリを全く異なるアプリで上書きする、という通常ではありえないことをやるので、思わぬ不具合が発生するかもしれません。  
データのバックアップは必ず取っておいてください。  
使用は自己責任でお願いします。  
何らかの不都合が起こったら教えていただけると助かります。
