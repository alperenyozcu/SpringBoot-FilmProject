# SpringBoot-FilmProject
Film Projesi Kullanıcıların admin tarafından eklenen filmleri listeleyip  filmler hakkında bilgi sahibi olması ve bu filmler hakkında görüşleri belirtmesi için geliştirilmiştir.
### Özellikler
#### Admin Ekranı
* Film Ekleme Silme Güncelleme.
* Film adı, oyuncu, ve film türüne göre arama yapabilme. 
* İlgili filmlere  birden fazla aktör ekleme.
* İlgili filmlere birden fazla dil seçeneği ekleme. 
* İlgili filmlere poster ekleme. 
* Eklenen filmleri listeleme.
#### Kullanıcı Ekranı
* Admin tarafından eklenen filmleri listeleme. 
* Admin tarafından eklenen filmleri detaylı görüntüleme. 
* Film adı, oyuncu ve film türüne göre arama yapabilme. 
* İlgili filimlere yorum ekleme. 

## Projeyi Çalıştırmak için 
 Projeyi ayağa kaldırmak için mySql veritabanında filmproject isimli yeni bir şema oluşturulmalıdır.
 Apllication.properties dosyası içerisinde veritabanı kullanıcı adı ve şifresi girilmelidir.
 ### İde Kullanarak 
  Proje kullanılan ide üzerinden veya github üzerinden clone edilip ilgili idenin çalıştırma konfigürasyouna FilmProjectApliication.java classı eklenmelidir.
 ### İde kullanmadan 
  filmproject isimli şema mySql veritabanında oluşturulduktan sonra target klasörü içerisindeki filmproject-0.0.1-SNAPSHOT.jar dosyası çalıştırılıp tarayıcıda  http://localhost:8080/ adresine gidilmelidir.
