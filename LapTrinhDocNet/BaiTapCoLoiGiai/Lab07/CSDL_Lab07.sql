create database Lab07
go

use Lab07
go
/*==============================================================*/
/* Table: KETQUA                                                */
/*==============================================================*/
create table KETQUA 
(
   MASO                   int                            not null,
   MAMH                int                  not null,
   DIEM                 int                            null,
   constraint PK_KETQUA primary key  (MASO, MAMH)
)
go


/*==============================================================*/
/* Table: KHOA                                                  */
/*==============================================================*/
create table KHOA 
(
   MAKHOA               int identity(1,1)                     not null,
   TENKHOA              nvarchar(30)                    null,
   constraint PK_KHOA primary key (MAKHOA)
);
go

/*==============================================================*/
/* Table: MON                                                   */
/*==============================================================*/
create table MON 
(
   MAMH                  int identity(1,1)                     not null,
   TENMH                nvarchar(50)                    null,
   SOTIET               int                            null,
   constraint PK_MON primary key  (MAMH)
);
go

/*==============================================================*/
/* Table: SINHVIEN                                              */
/*==============================================================*/
create table SINHVIEN 
(
   MASO                  int identity(1,1)                             not null,
   HOTEN                nvarchar(50)                    null,
   NGAYSINH             datetime                       null,
   GIOITINH             bit                            null,
   DIACHI               nvarchar(50)                    null,
   DIENTHOAI            nvarchar(11)                            null,
   MAKHOA              int                     null,
   constraint PK_SINHVIEN primary key  (MASO)
);
go

alter table KETQUA
   add constraint FK_KETQUA_SINHVIEN foreign key (MASO)
      references SINHVIEN (MASO)
      on update cascade
      on delete cascade;
go

alter table KETQUA
   add constraint FK_KETQUA_MON foreign key (MAMH)
      references MON (MAMH)
      on update cascade
      on delete cascade;
go

alter table SinhVien
   add constraint FK_SINHVIEN_KHOA foreign key (MaKhoa)
      references KHOA(MaKhoa)
      on update cascade
      on delete cascade;
go

insert into KHOA(TENKHOA)
values(N'Y') 
go
insert into KHOA(TENKHOA)
values(N'Công Nghệ Thông Tin') 
go
insert into KHOA(TENKHOA)
values(N'Kinh Tến') 
go
insert into KHOA(TENKHOA)
values(N'Dược') 
go
insert into KHOA(TENKHOA)
values(N'Môi Trường') 
go

Select sv.HOTEN,sv.NGAYSINH,k.TENKHOA,mh.TENMH,kq.DIEM 
from SINHVIEN sv,KHOA k ,KETQUA kq ,MON mh 
where sv.MAKHOA = k.MAKHOA 
		and sv.MASO = kq.MASO 
		and kq.MAMH = mh.MAMH 
		and sv.MASO = kq.MASO 
		and sv.MAKHOA = k.MAKHOA
go

select * 
from SINHVIEN
go