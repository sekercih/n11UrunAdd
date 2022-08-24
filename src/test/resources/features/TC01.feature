@n11
Feature: N11 Favorite Product Scenario

  Scenario Outline:User should be able to add the product to my favorites when logged in

  Given Kullanici "https://www.n11.com/" sitesinin anasayfasina gider.
  Then Ana sayfanin acildigi kontrol edilir.
  When Siteye login olunur.
  Then Login islemi kontrol edilir.
  And "<product>" kelimesi aranir.
  Then "<product>" kelimesi aratildigi kontrol edilir.
  And Arama sonuclari sayfasindan 2. sayfa acilir.
  Then 2. sayfanin acildigi kontrol edilir.
  And Sayfadaki 3. urun favorilere eklenir.
  And Favorilerim sayfasina gidilir.
  Then Favorilerim sayfasi acildigi kontrol edilir.
  And Eklenen urun favorilerden silinir ve silme islemi kontrol edilir.
  Then Uye cikis islemi yapilir.
    Examples:
      | product |
      |Iphone |
