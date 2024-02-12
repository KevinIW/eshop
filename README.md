
<details>
    <summary> Modul 1 </summary>

Refleksi 1:

<br>
    Pada penambahan 2 fitur diatas yaitu edit product dan delete product. Dibuat terpisah 
dalam 2 branch, Dipisahkan agar fitur kodingan diatas lebih rapi dan enak dibaca sehingga 
sewaktu-waktu jika terjadi bug akan lebih gampang untuk dideteksi dan diperbaiki. Menurut saya,
kode yang saya bikin saat ini masi rentan terhadap security dikarenakan saya belum melakukan testing. 
Sehingga perbaikannya selanjutnya adalah melakukan testing pada kode yang sudah jadi. Kode setiap branch sudah
terstruktur dan gampang tetapi harus pindah-pindah branch kadang. Menurut saya, dua branch ini masi bisa digabung agar lebih efisien
tetapi untuk kasus lainnya mungkin branchnya harus dipisah. Biasanya fitur edit dan delete product digabung tetapi ini
malah dipisah


<br>

Refleksi 2 :

<br>
    Saya merasa setelah mengerjakan unit test diatas adalah kodingan yang saya tulis jadi tidak ada bug.
Karena sudah banyak di test sehingga ketika user memasukkan beberapa input tidak akan terjadi error kecuali
input yang diberikan seperti string atau character pada product quantity. Untuk memastikan program diatas
dapat berjalan dengan baik setidaknya ada banyak input yang dicobakan saat testing. 
    Jika memiliki code coverage 100 belum tentu bebas tanpa bug dan error karena ada test yang bisa sajs terlewatkan
atau ada test yang kualitasnya buruk. Menurut saya, jika akan mengurangi kualitas kode karena ada beberapa hal yang buruk.
Seperti adanya duplikasi kode, beberapa nama variable yang kurang meaningful dan karena ada banyak kode menjadikan
kode tersebut berpotensi banyak bug.Untuk itu masi ada beberapa perbaikan yang dapat dikerjakan.
    





</details>

<details>
<summary> Modul 2</summary>

1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.

Ada beberapa code yang saya tambahkan untuk memperbaiki code coveragenya. 
Pertama dalam  code coverage saya menambahkan unit test pada controller,model, repo, dan service.
Setelah ditambahkan kode saya menjadi 97%. Semua kondisi yang bisa terjadi dalam repo saya test sehingga code saya
bisa bebas dari bug. Lalu untuk quality lainnya saya tambahkan SonarCLoud unutk mengscan code saya sehingga saya tau ada
kekurangan dimana. Lalu juga saya tambahkan CodeQl untuk memperbaiki lagi kode saya. Sebelumnya workflow yang ditambahkan dalam bidang security
score card sudah menampakan beberapa kekurangan yang ada lalu saya memperbaiki beberapa kekurangan itu.


2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!

Menurut saya kode workflow saya sudah mengimplementasikan CI/CD. Pertama dari CI, di Workflow ci.yml sudah berjalan dengan benar dan terus-terusan. 
Kedua dalam CD, sudah bisa di deploy dan berjalan dengan baik dan bisa di update setiap melakukan push ke repo. 
Pada ci.yml dilakukan terus terusan testing untuk melihat apakah kode nya berjalan dengan benar. 
Lalu pada scorecard.yml dilihat dalam segi security apakah kode repositorynya sudah secure dari ancaman luar.
Lalu dengan sonarcloud.yml untuk melihat apakah kode nya ada bug di setiap push.
Lalu ada codeql.yml untuk mengintegrasikan CI/CD setiap push.

</details>



