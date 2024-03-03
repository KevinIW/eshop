
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


<details>
<summary> Modul 3</summary>

Reflection :

Pada tugas kali ini disuruh untuk mengaplikasikan SOLID principle.
Di project ini saya mengaplikasikan yang pertama Single Responsibility Principle.
 Saya membagi ProductController yang berisi class CarController. Lalu saya juga membagi
semua method yang ada di repository sehingga setiap method terbagi tugasnya dalam 1 file contohnya ada di 
UpdateCar.java dan DeleteCar.java. Selanjutnya ada Open-Close principle, Saya menerapkan hal itu pada bagian model
sehingga mereka terbagi menjadi 2 class dan selanjutnya jika ingin ditambahkan attribute langsung bisa dilakukan
tanpa mengubah module lain lagi. 

Untuk prinsip selanjutnya yaitu Liskov Substituion Principle saya mengubah kode pada
CarController yang awalnya merupakan sebuah subclass dari ProductController. CarController tidak harus
menjadi subclass dari ProductController sehingga saya memecah CarController menjadi sebuah class yang tidak bergantung pada productcontroller.
Sehingga Liskov terapply karena tidak ada subclass pada semua kode saya. Pada Interface Segregation, saya mengabungkan 2 interface yang ada 
pada CarService dan ProductService. Saya gabungkan agar semua method menjadi lebih sederhana dan agar semua method
tidak harus dipaksa dipakai saat misalkan membuat sebuah service baru.
Pada Dependency Inversion, semua kode pada service sudah bergantung pada interface sehingga memenuhi principle tersebut.

Single Responsibility Principle (SRP):

Keuntungan: Memisahkan tanggung jawab setiap kelas membuat kode menjadi lebih mudah dipahami, dipelihara, dan diperluas.

Kerugian: Kadang-kadang memisahkan tanggung jawab secara ekstrem dapat menghasilkan banyak kelas kecil yang sulit untuk dikelola dan dipelihara.

Contoh: Pada Controller dipisah dan pada repository beberepa method dipisah

Open/Closed Principle (OCP):

Keuntungan: Memungkinkan perluasan fungsionalitas tanpa harus memodifikasi kode yang sudah ada, sehingga meningkatkan modularitas dan mengurangi risiko kesalahan saat melakukan perubahan.

Kerugian: Penerapan OCP yang berlebihan dapat menghasilkan struktur kode yang terlalu kompleks dan sulit untuk dipahami.

Contoh :Pada model bisa langsung ditambahkan attribute dan di interface juga bisa langsung ditambahkan

Liskov Substitution Principle (LSP):

Keuntungan: Meningkatkan fleksibilitas dan skalabilitas kode dengan memungkinkan penggantian objek superclass dengan objek subclass tanpa mengubah perilaku program.

Kerugian: Penerapan yang tidak tepat dapat menghasilkan hierarki kelas yang rumit dan sulit untuk dimengerti.

Contoh: pada subclass CarController tidak dijadikan subclass lagi

Interface Segregation Principle (ISP):

Keuntungan: Membuat antarmuka yang lebih bersih dan fokus, mengurangi ketergantungan pada metode yang tidak digunakan, dan memudahkan pemeliharaan dan pengembangan kode.

Kerugian: Memecah antarmuka terlalu kecil dapat menghasilkan banyak antarmuka yang membingungkan dan sulit untuk dipelihara.

Contoh: Interface yang digabung pada service

Dependency Inversion Principle (DIP):

Keuntungan: Mendorong ketergantungan yang longgar antara modul dengan memastikan bahwa modul-level tinggi bergantung pada abstraksi daripada implementasi konkret, yang memudahkan pengujian unit dan penyuntikan dependensi.

Kerugian: Memperkenalkan lapisan abstraksi tambahan dapat meningkatkan kompleksitas kode, dan penerapan yang tidak tepat dapat mengakibatkan overhead yang tidak perlu.

Contoh: semua service memakai interface

    



</details>

<details>
 <summary>Modul 4</summary>

Reflection:

1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.


Menurut pendapat saya, TDD kurang begitu bagus karena alurnya yang aneh dan tidak logis. Semisal saat kita membuat test maka kita
akan lebih fokus pada testingnya bukan fitur programnya. Dan juga menurut saya kurang efektif, karena kita harus memikirkan tentang membuat test dulu
yang pada dasarnya manusia membuat kode dulu baru melakukan testing. Memang TDD membuat kencenderungan menghasilkan bug yang kecil
namun karena pembuatan TDD yang rumit dan aneh maka saya lebih prefer untuk membuat kodingan terlebih dahulu.


2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.

Dari Principle F.I.R.S.T, 

untuk F yaitu fast, saat kode di run hanya membutuhkan waktu kurang dari waktu 1 s serta tidak menggangu workflownya
sehingga terpenuhi

Untuk I yaitu Isolated/Independent, dari kode saya diatas ini test yang dibuat semua tidak ada yang bergantung pada
method test case lainnya sehingga terpenuhi.

Untuk R yaitu repeatable, bisa dibuktikan dengan menjalankan test beberapa kali dengan hasil yang sama yaitu passed semua maka terpenuhi

Untuk S yaitu Self-Validating, semua test case saat menguji semua method ada yang memakai assertEqual atau assertNull atau
assertThrow sesuai kebutuhan dan juga memenuhi semua kondisi untuk 1 method maka konsep ini juga terpenuhi

Untuk T yaitu thorough/timely, setiap file di service, repository, dan model memiliki happy path dan unhappy path yang mengcover semua test case serta
test case yang dibuat sudah minimal mungkin maka memenuhi hal ini.



</details>



