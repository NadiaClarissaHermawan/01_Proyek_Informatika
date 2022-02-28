repository folder berisi interface yg extends JpaRepository.
Dalam interface tsb memuat method" u/ melakukan operasi CRUD & other operations thd database

CRUD operations thd tabel train tidak perlu ditulis ulang disini
karena sudah included pada JpaRepository yang di extend & bisa langsung dipakai.
kecuali, jika ingin menambahkan operasi custom, tambahkan di repository abstract methodnya.