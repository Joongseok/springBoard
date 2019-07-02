select * from not_exists_in_prd_db;

--users 테이블 초기화
delete uploadFile;
delete noti_comment;
delete notice;
delete board;
delete users;
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('LJS','이중석','테스트','3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','대전 대덕구 갑천도시고속도로 23','415','34305',to_date('19/06/27','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('text','text','at','76592b9de6d38238a52a3651867871e5c670e632a8ef46a84b559f8933f33e','광주 서구 2순환로 2344','ㅁ5','61900',to_date('19/05/21','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('at','text','at','c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('userTest','test','test','test','test','test','test',to_date('19/05/31','RR/MM/DD'),'test','test');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('userTest2','대덕인','중앙로','308caa642ae3f0be8ed54ffbe4ca60642c7d1bc762f9fc6ca26acaf32393925','대전광역시 중구 중앙로76','영민빌딩 2층 대덕인재개발원','34940',to_date('19/05/31','RR/MM/DD'),'a','ryan.png');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('userTest3','56124124','489','bad9a6f0e28076da5c45d47f5cd8b3c01358faee62d79df5c2a6f65f8e94ab3','서울 강북구 오현로25가길 7','a25','01146',to_date('19/05/16','RR/MM/DD'),'a','moon.png');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('21512','15125','125125','66c03337b22c301d55a339a94165dc9628491c3dfe01a57ef62e3eab452e898','충북 청주시 청원구 1순환로 42','12512','28322',to_date('19/06/20','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('atastatastastastast','a25a2','a25a25','d534d79289612fcd7f721babe03123178117caeacc64a93751f911b4b5e11e','광주 서구 2순환로 2344','aq25a25','61900',to_date('19/06/07','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user27','사용자27','사용자별명27','e967945b51d925425bef8a55b6fc28be31458a8a35439a48b6858251b69935c5',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user29','사용자29','사용자별명29','2d564053407ca7517d95a11396e85d38941c79f7a8fef244e8e0b8cf1a1377',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user30','사용자30','사용자별명30','b77ab72238de29d8b843e9b0a253809438d34b8ed931b94dfc4d929fb7ed',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user32','사용자32','사용자별명32','8820331a867ed350d24bc3f87a8d0a8e4645be72c92f2a779366553cce4',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user34','사용자34','사용자별명34','791ab764ed7877c2669f87a1a856d76f69ec3c01aea7da088e737719e239695',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user36','사용자36','사용자별명36','9c4e977cd912bf4a7ca8fdb6dd6938218798e63618b9ef99e2a1c9ddd07097',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user38','사용자38','사용자별명38','4c1dda29fc915e46b7618d4bc97b89c8d095f8c7843c945f6608cff7c6efb',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user39','사용자39','사용자별명39','2e7e9951d458d364f737824049d67d28c7f99e1e9dd6d79dd1a3bfb89289a',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user41','사용자41','사용자별명41','7434b83ca1ae7e27a3329ede2f744c1cd63d88ab4cd09ba3b013ba59b35731f7',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user43','사용자43','사용자별명43','23a8d84457ea8f507eb6e6e3c9f4a41a3a6868e2cf067d8f42adf195ee9316',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user45','사용자45','사용자별명45','aa73769d6edfac7fd7a67e853e4b180da52acd56fdd20518215243ab0a85f',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user47','사용자47','사용자별명47','d82295a57b78adb78c7e8b446722139442d4bfec95aa271ea93bea4ec365afd3',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user48','사용자48','사용자별명48','d249abc8c0c2d6ca76be2a85ba15db94c8502da6d0d5c890b1e592d4d4b5ad43',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user50','사용자50','사용자별명50','b17bbbd98b4b468efc7bab842ce7dc115497547c7ea8fcc3e04a5bc5c0242e',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user52','사용자52','사용자별명52','4e50a8f9c55fce6e52c7cdac2ffca9f1b1e9a9914c966da497fbaf3e0b1668f',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user54','사용자54','사용자별명54','741de0be418f63aaeb683371c1e4fcd6199c546519a382ea0f6794bc4f727a3',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user56','사용자56','사용자별명56','e66dbb98f7381a2f2a5b6de3ec5787f6e4a62e16cc7398181f261bb66576d60',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user57','사용자57','사용자별명57','beb5b83541f3a23ea857fb350917e35e87ea3d9c9737fcf7808597c9803969',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user59','사용자59','사용자별명59','c248c4b5557a9c678ee25917ee51cc6f85eafdb9d51b967473b2b6eb85e38be',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user61','사용자61','사용자별명61','2c18215bc353d1ba45ccc4a9a4ebcf95191f73926af4d71e082f37580504','광주 서구 2순환로 2344','ㅁ5','61900',to_date('19/05/21','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user64','사용자64','사용자별명64','c04854681268ae0459ba6256dd25c31bf277f374d1859bce2295758d55354',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user66','사용자66','사용자별명66','378a8c8e501d6dc32912257c316a21a2f059d5e7f07080b17e157050ba06a',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user68','사용자68','사용자별명68','2dbcda9528b7a7626a165eb969b1b831b4ede4adbc1c7c36f1a9a7d6c9d7d',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user69','사용자69','사용자별명69','2eaa12e0245f55209ed6ba728bd5db91501723b314b2f5462b4a9f4d4c4d1f1',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user71','사용자71','사용자별명71','c2fb8778f9f43a78e71d395e989387d8fd01dd56e705e9ae934bfa5cbefeaf',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user73','사용자73','사용자별명73','63c717caa7f9e42221272170235b4e70ab96fc6cc7a6f6f7eac888fbcdbaa258',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user75','사용자75','사용자별명75','e7987566b643f5121cbe908ac9c92167d08d9947a5611fbc89bd7cc093e6',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user77','사용자77','사용자별명77','5322e463281a421c27ebae528c58e99bd83c5b97bd4f9ec7a6833aab8d83f',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user78','사용자78','사용자별명78','7f46cd28483747ce46e42e8661358fb6a361d7dfbe1f0a3dbef7714e16530d6',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user80','사용자80','사용자별명80','6fa7ce61bed9e6f96c7e73f4dfa2deb06dc7292cfbe08975e17675ba14bbc3f2',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user82','사용자82','사용자별명82','ff28be191149a53d6106091bf9e5d77cc5414313a4478dfef68c188a46042f1',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user84','사용자84','사용자별명84','bdabd033bd25a14c759ca8bc813de35af0d2bbba868f1946237cde8d47ee273',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user86','사용자86','사용자별명86','8039345fd0c45b090ecb3a62610859a544fd525e032b34fb066ea312e7c486e',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user88','사용자88','사용자별명88','e96465c3debc2c58766773f157c926fe68a58c309529a96bf14bb17e93b27e',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user89','사용자89','사용자별명89','a0fb8631e6ff42f9a7973da848ab3f17d76353927805a7c9b7c4cfbb7c053a6',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user91','사용자91','사용자별명91','1cfd38793c74c7812326c63e7b82662e39e4332ce35732c6fdff593bbf6736d9',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user93','사용자93','사용자별명93','6c6e3adedc82757f69f4d6bcfb37beb82998af774be1f7a20c03b73caeb8a84',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user95','사용자95','사용자별명95','92b9df1e3014e39e9df8edb9c61b165dd78c61e0aac1d4db68b38fc29f441a','강원 정선군 정선읍 5일장길 11','6','26130',to_date('19/05/19','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user98','사용자98','사용자별명98','e4ec5cc71686ac98f0b05d11b6dc1ce1bcd9dc44f3108347be65a0ada5a68',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user100','사용자100','사용자별명100','69bc7955d9b77a2fe4ca99f6fc2b1ff819ddd96ff7a9556efc31171668cee3',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('test','test','test','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2bb822cd15d6c15b0f0a8','test','test','test',to_date('19/05/31','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('Test215125125125215','tawtw','awtawt','ffd49412558b11de54a7e76b1d545c521371e7bbc771de99147ab858a08c62','광주 서구 2순환로 2275','awt','61954',to_date('19/06/19','RR/MM/DD'),'d:\upload\2019\06\e94b2cd2-7487-4757-a412-bbb2b3913faf.png','ryan.png');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('brown','브라운','곰','c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44','대전광역시 중구 중앙로 76','영민빌딩 2층 대덕인재개발원','34940',to_date('00/08/08','RR/MM/DD'),'D:\upload\brown.png','brown.png');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('sally','샐리','병아리','4aeaaaccd26ed685e4e3c563bcdb1f9d1dabd77f1b7b819625679936648d49c9',null,null,null,null,'D:\upload\sally.png',null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('moon','문','달','7a37a8623ff85b19476f7d052349e1d57e5bded313cccdea99b9601e1ace5d',null,null,null,null,'D:\upload\moon.png',null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('cony','코니','토끼','de1153428acef7fd7b999f1227d4882146bd7ea16b595b43bf5090d41d3637','충북 청주시 흥덕구 1순환로 384','125125','28456',to_date('19/06/19','RR/MM/DD'),'d:\upload\2019\06\765c483e-e92d-49c9-958e-736e73886cd8.png','d:\upload\2019\06\765c483e-e92d-49c9-958e-736e73886cd8.png');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('james','제임스','사람','6765c531920463d7bb44112f8f21abcea85913e3197978828fbd076d1d36f4d',null,null,null,null,'D:\upload\james.png',null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user1','사용자1','사용자별명1','9cc2b6f91a9aa858e66c44eb6b86b3473d46cfde68378063f16e3ca2feea7a74',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user2','사용자2','사용자별명2','d3f89a9fdd6a60b9556d463aac6dc19486b3a555287ace6b24bf9f22ceca',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user3','사용자3','사용자별명3','5d3e9f1dda13570c6444918edc1879bd9cd8c31d6c41d701311b0bf1225d868',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user4','사용자4','사용자별명4','c5e4735904e3c98fec3276c03c5fa4c23e6bd983b38db1c5ef9c796b533142',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user5','사용자5','사용자별명5','e9075ddcc53c82b7e27fe18cab0361dafccba6fcf3c6b3d80fc5e69192f75c1',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user6','사용자6','사용자별명6','23baa82d192824e7fb5489b0249bf95e2c11bbfd564cca439dad7221f8cf',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user7','사용자7','사용자별명7','6740c2aa92b270e3356f939cccf2bd42e07a733ef55cd55475e8f7d5c36d2',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user8','사용자8','사용자별명8','a52da9508c2ac25e1337fb764f8158beec95592d5f5befb472170d05d1154fa','전남 구례군 구례읍 5일시장길 5',null,'57639',to_date('19/05/31','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user9','사용자9','사용자별명9','5ff9b172f2f9b0a88610f6d6305b86e2ecc1880ac146dd2587acff41d0ef',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user10','tt','t','8874e915d0ff492fdeff6595804510bd9e6ed8648e69df68957c74d24626127','광주 서구 2순환로 2344','2','61900',to_date('19/05/31','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user11','사용자11','사용자별명11','a49e3e154fc9cb2954268aab9338f6912469dc49bf9349a1195bcdc499d77',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user12','사용자12','사용자별명12','823a7f65965f24b899bfa4df6f1cf6fa0acaf86c190ca81819ea4358d55f4',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user13','사용자13','사용자별명13','35558f479a4182c2ac4e46d267a6b43a05ba91abdf3ccda10bcfc5c33d6f48',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user14','사용자14','사용자별명14','99742881b35dfdbbfbcf1558e67424f5ab862f0b0e9e3a868fcbb011435264',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user15','사용자15','사용자별명15','f9e3f7ac808afa1a5cdfd56327517366a29ee58bc0dacc46ddd40884cab13','경북 구미시 1공단로 15-37','35','39347',to_date('19/05/31','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user16','사용자16','사용자별명16','64bf32a5414d0b25d3b3259a5ad15d082365ca5e871f75fa858eb263b5b6d',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user17','사용자17','사용자별명17','b62e3cb3b7169184be2f2e930e1f19398c436831a74c3374572ade1fbcf70',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user18','사용자18','사용자별명18','f2473dcf4b71d213c338b942dab262fb6ed3a8b52e4760852c89eb1413fd0',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user19','사용자19','사용자별명19','f85871f5a0ffc1d5c4912dda4acde12ddf1c5f47fc8ab2e9ec29622b2361a1d',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user20','사용자20','사용자별명20','135528e82020afd6859e378a30234724f0d2686a59c3452da2520d8ae2351',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user21','사용자21','사용자별명21','e73bf7d4f0bed66f2fcd842173d94f3f949e655774a8661d53f4709fab3a',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user22','사용자22','사용자별명22','cdac3db04ed1d06bef934d3c7877e90bbb0164f52b9e6b1c574d4ed6e1d39',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user23','사용자23','사용자별명23','f9efb021717945e88832fa657d91e2bc6fe1541286915ec81433393c5cf7cca',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user24','사용자24','사용자별명24','2bc2c8ac6d96cf1d16a09ab9d4efa857dc8b761784b58f85e9edd8af58b38266',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user25','사용자25','사용자별명25','9d81c54437ec11d96ef8a9dce599a46d2de988482bfce1fe79712378482157',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user26','사용자26','사용자별명26','83fafcdcabacacab3cd9e7217f958496fa92f6da839b53a8f7542b69c32f7fd',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user28','사용자28','사용자별명28','6a6a1073cf685a795815ff32931a572af85aded4d24987b642c0108d7a1282',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user31','사용자31','사용자별명31','5095f3b379abfcf67cb7f471c893f8f564c1d6d5d9ee06973efbb65772f2e',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user33','사용자33','사용자별명33','4a89a75c984e5ac5b617fb8560c85a74ebe012a1164fc1b5af4d9937beac216',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user35','사용자35','사용자별명35','97acfdc8e57cab966cfc58ecbae75fa7cceffeb0289f637516fa2aa7a5e8341',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user37','사용자37','사용자별명37','ef2512443e9b5a3ee314f4ec80d2e266b7ade58dc0cb36fac7a9d944c2caf7',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user40','사용자40','사용자별명40','99c430be1960d7f8283bfb2a62312ddd13cd2a4c196dff6b70be584c2ee2cc',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user42','사용자42','사용자별명42','299730af828ae633f233da7707ec819d85564f1e8bc313ac2def523cf5b9240',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user44','사용자44','사용자별명44','c2aef017be6bea9d7751131ab4fc561592bd7e21cb83d854e5d177eb87ea66d',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user46','사용자46','사용자별명46','5942cdf0404ff1aec29440036280be2bde7ed7ff9fee4c14aa6e676d7b490',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user49','사용자49','사용자별명49','754208645e2c95db2afe423adf88881b41c469e99b54aee1e57464b7573caf',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user51','사용자51','사용자별명51','ab5189e9bab59f6ea4a8157c363242c586b849561a77333f6c34abff63f65ba',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user53','사용자53','사용자별명53','7ab413f5a1f1b0ed698995141056af2b688f3b4c2e9c623772bd649b53f11e5a',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user55','사용자55','사용자별명55','c8dfcb2d2e5b6320295e42ebf2d74cb366cc64157e37757147fe1424ce455897',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user58','사용자58','사용자별명58','81442204f5029dd70706a6c191415449d4ff191c62aa37547fedcd7b0846',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user60','사용자60','사용자별명60','ea3f5485d084c895d8f19007630f01ecb798c524ecd315cd887ff2a63f5a8',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user62','사용자62','사용자별명62','d64162d714b8532164ea6d7473e11836eec4721eef88ca14fbae2585d52','경기 평택시 포승읍 2함대길 40','2','17950',to_date('19/05/31','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user63','사용자63','사용자별명63','ccae939dce39aaddc599ade0ae849532dbedafc6682697a92dc1b9f70a5918',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user65','사용자65','사용자별명65','dcb699d25ebb22a3a77407c25afb909aab6ece6d78fcbc5fcd7610840f',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user67','사용자67','사용자별명67','d1448011266c76e9ae9f5f547a6bb2ba51aeec2cbdb580d42ce3c4c930b8beb7',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user70','사용자70','사용자별명70','571af112473ce0abea49a694b8f1155279ba87d26bdfe55ebc3233667ed77b','충북 청주시 청원구 1순환로 42','a','28322',to_date('19/05/31','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user72','사용자72','사용자별명72','d7c37c6f8f7d6b42790729808c71b1b5c126e3d47b0c474a53ab62752d3f',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user74','사용자74','사용자별명74','e3696d799d58ef1182060302e3362b1c56381f8675e17b660ab58992f1db3b',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user76','사용자76','사용자별명76','e57bbfe75ba3c1142b131c85a6e46b746a653bdf3e74b7811d8ff27e0ea92',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user79','사용자79','사용자별명79','d1e0c7bdeb5610d839b02791b1b8f018cc659b2acd1eb357fa842a33c4',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user81','사용자81','사용자별명81','f095e2e0c3933d4d4cebb89dc44fe068ec514e1de13eebde4a35efb9b6385b',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user83','사용자83','사용자별명83','6f3eb569ad8d2c9137dccef760537ee4bf4ec1442e70acb6f5b9a5bc8115b',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user85','사용자85','사용자별명85','c81abf1fd96c193f93a4911b4c128ceb6650e7b2b27d6d70a43574b9ba468c',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user87','사용자87','사용자별명87','a582e868b18927e695cf60537ac4941330ae31ef3b2db0c73ea3c83c57cd',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user90','사용자90','사용자별명90','a057d98b8819dadad238ae95f1a56e05a1443482c93236bfcebed1384d9a6c',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user92','사용자92','사용자별명92','26b3ad55629323ca3e6ad3921a7384161b15dd0c29a11bb2a9d74c7c2d2f725',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user94','사용자94','사용자별명94','c57b9661f4ae3f309f988c2b6a9a9f21cd66895cad2cb3ab92d2688ad12d2d7',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user96','사용자96','사용자별명96','5446f05a705aa2498cc3926a13e7b192db1ba9d493c351e34135e7d31dfa',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user97','사용자97','사용자별명97','dc8de33ea13b2bae489451cd6f1dbed18484219e1dc12b5d38a07c2b94fa8',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('user99','사용자99','사용자별명99','20bbc85c57c06695ea7703d5cd9e64d10dd77c44850ec15d14da21b232d673',null,null,null,null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('1test1','test','test','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2bb822cd15d6c15b0f0a8','test','test','test',to_date('19/05/31','RR/MM/DD'),'test','test');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('sfasafasfas','fasfasfas','fasfasfasf','be4c684f23e55026dfa6278f4344f982f1812fb733ed51604b8140e659b8f391','광주 광산구 2순환로 2476','afasfasf','62316',to_date('19/06/21','RR/MM/DD'),'d:\upload\2019\06\d657ae79-7f83-4e3c-bdff-199ca3f19e97.png','cony.png');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('12512','125125','12512512562`1','3b11a134e2e65596f755f62c09da6295349bfb324ac9cffc0c2a8d9e7fdbe32',null,'125125125',null,to_date('19/06/18','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('ㅁㅈㄱ','ㅁㄱㄴ','ㅁㅈㄱ','45158281e27a2c78c6c63071be4ba6a7c841d542cf46ad5e9b2f4902e93ffe7','광주 서구 2순환로 2344','ㅁㅈㄱ','61900',to_date('19/05/14','RR/MM/DD'),null,'ryan.png');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('aw45w','5aw5aw5','aw5aw5aw5','5a118ef19c1154e0ac5161faedd3fc61ffdeddee8d6eb864f2e2165ed72d86d','서울 관악구 봉천로21가길 1','aw5aw5','08719',to_date('19/06/18','RR/MM/DD'),'d:\upload\2019\06\cf0b35b6-2b9e-483b-b2d9-4f24c9851cd4.png','cony.png');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('userTest125125','대덕인','중앙로','d86f64c86b3ceaa3ab2a755618d61ad378f77b57568635742c49aa810c36ba','대전광역시 중구 중앙로76','영민빌딩 2층 대덕인재개발원','34940',to_date('19/05/31','RR/MM/DD'),'d:\upload\2019\06\dbab7605-fafb-4ad2-9621-bf729dde9d11.png','james.png');
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('userTest2521','대덕인','중앙로','308caa642ae3f0be8ed54ffbe4ca60642c7d1bc762f9fc6ca26acaf32393925','대전광역시 중구 중앙로76','영민빌딩 2층 대덕인재개발원','34940',to_date('19/05/31','RR/MM/DD'),null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('userTest15125215','대덕인','중앙로','308caa642ae3f0be8ed54ffbe4ca60642c7d1bc762f9fc6ca26acaf32393925','대전광역시 중구 중앙로76','영민빌딩 2층 대덕인재개발원','34940',null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('userTest111231312','대덕인','중앙로','308caa642ae3f0be8ed54ffbe4ca60642c7d1bc762f9fc6ca26acaf32393925','대전광역시 중구 중앙로76','영민빌딩 2층 대덕인재개발원','34940',null,null,null);
Insert into PC25_TEST.USERS (USERID,NAME,ALIAS,PASS,ADDR1,ADDR2,ZIPCD,BIRTH,PATH,FILENAME) values ('1','2고고고고곡a5aw5aw5wa5','1aw5aw5w5','76b5265bb0a3ef6a892cae828ce1872c895ccd70c8f640e0b5d157bc692b2',null,null,null,null,'d:\upload\2019\06\d2977770-820b-409c-994e-7516a38c748c.png','moon.png');
Insert into PC25_TEST.BOARD values (1,'brown','자유 게시판','true',SYSDATE);
Insert into PC25_TEST.BOARD values (2,'brown','공지 게시판','true',SYSDATE);
Insert into PC25_TEST.BOARD values (3,'brown','테스트 게시판','true',SYSDATE);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (1, 'brown', '테스트 제목1', '테스트 내용1', SYSDATE, NULL, 1, 'true', 1);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (2, 'brown', '테스트 제목2', '테스트 내용2', SYSDATE, NULL, 1, 'true', 2);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (3, 'brown', '테스트 제목3', '테스트 내용3', SYSDATE, NULL, 1, 'true', 3);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (4, 'brown', '테스트 제목4', '테스트 내용4', SYSDATE, NULL, 1, 'true', 4);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (5, 'brown', '테스트 제목5', '테스트 내용5', SYSDATE, NULL, 1, 'true', 5);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (6, 'brown', '테스트 제목6', '테스트 내용6', SYSDATE, NULL, 1, 'true', 6);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (7, 'brown', '테스트 제목7', '테스트 내용7', SYSDATE, NULL, 1, 'true', 7);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (8, 'brown', '테스트 제목8', '테스트 내용8', SYSDATE, NULL, 1, 'true', 8);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (9, 'brown', '테스트 제목9', '테스트 내용9', SYSDATE, NULL, 1, 'true', 9);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (10, 'brown', '테스트 제목10', '테스트 내용10', SYSDATE, NULL, 1, 'true', 10);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (11, 'brown', '테스트 제목11', '테스트 내용11', SYSDATE, NULL, 1, 'true', 11);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (12, 'brown', '테스트 제목12', '테스트 내용12', SYSDATE, NULL, 1, 'true', 12);
Insert into PC25_TEST.NOTICE (NOTIID, USERID, TITLE, CONTENT, REG_DT, PARENTID, ID, DEL_YN, GROUPID) values (13, 'brown', '테스트 제목13', '테스트 내용13', SYSDATE, NULL, 1, 'true', 13);
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (1, 1, '테스트 댓글1', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (2, 2, '테스트 댓글2', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (3, 3, '테스트 댓글3', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (4, 4, '테스트 댓글4', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (5, 5, '테스트 댓글5', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (6, 6, '테스트 댓글6', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (7, 7, '테스트 댓글7', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (8, 8, '테스트 댓글8', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (9, 9, '테스트 댓글9', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (10, 10, '테스트 댓글10', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (11, 11, '테스트 댓글11', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (12, 12, '테스트 댓글12', SYSDATE, 'true', 'brown');
Insert into PC25_TEST.NOTI_COMMENT (ID, NOTIID, CONTENT, REG_DT, DEL_YN, USERID) values (13, 13, '테스트 댓글13', SYSDATE, 'true', 'brown');


commit;
