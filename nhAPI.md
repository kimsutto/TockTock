# NH Developers 

### HTTP Method : POST 
### contentType : application/json 

## 핀-어카운트 직접 발급
https://developers.nonghyup.com/OpenFinAccountDirect_nh

Request
```json

{
  "Header": {
    "ApiNm": "OpenFinAccountDirect",
    "Tsymd": "20201213",
    "Trtm": "112428",
    "Iscd": "000701",
    "FintechApsno": "001",
    "ApiSvcCd": "DrawingTransferA",
    "IsTuno": "00001",
    "AccessToken": "7e4615cdfe6c788efb282bfad00e78629bb505ba4bc881867121cb92b5b9d8bd"
  },
  "DrtrRgyn": "Y",
  "BrdtBrno": "19981106",
  "Bncd": "011",
  "Acno": "3020000002986"
}

```
Response
```json
  "Rgno": "등록번호"
```

## 핀-어카운트 직접발급확인
https://developers.nonghyup.com/CheckOpenFinAccountDirect.nh

Request
```json

{
  "Header": {
    "ApiNm": "CheckOpenFinAccountDirect",
    "Tsymd": "20201213",
    "Trtm": "112428",
    "Iscd": "000701",
    "FintechApsno": "001",
    "ApiSvcCd": "DrawingTransferA",
    "IsTuno": "00002",
    "AccessToken": "7e4615cdfe6c788efb282bfad00e78629bb505ba4bc881867121cb92b5b9d8bd"
  },
  "Rgno": "등록번호",
  "BrdtBrno": "19981106"
}

```
Response
```json
  "FinAcno": "핀-어카운트",
  "RgsnYmd": "등록일자"
```

## 핀-카드 직접발급
https://developers.nonghyup.com/OpenFinCardDirect.nh

Request
```json

{
  "Header": {
    "ApiNm": "OpenFinCardDirect",
    "Tsymd": "20201213",
    "Trtm": "112428",
    "Iscd": "000701",
    "FintechApsno": "001",
    "ApiSvcCd": "DrawingTransferA",
    "IsTuno": "00003",
    "AccessToken": "7e4615cdfe6c788efb282bfad00e78629bb505ba4bc881867121cb92b5b9d8bd"
  },
  "Brdt": "19981106",
  "Cano": "9411123456782718"
}  

```
Response
```json
  "Rgno": "등록번호"
```

## 핀-카드 직접발급확인
https://developers.nonghyup.com/CheckOpenFinCardDirect.nh

Request
```json

{
  "Header": {
    "ApiNm": "CheckOpenFinCardDirect",
    "Tsymd": "20201213",
    "Trtm": "112428",
    "Iscd": "000701",
    "FintechApsno": "001",
    "ApiSvcCd": "DrawingTransferA",
    "IsTuno": "00004",
    "AccessToken": "7e4615cdfe6c788efb282bfad00e78629bb505ba4bc881867121cb92b5b9d8bd"
  },
  "Rgno": "등록번호",
  "Brdt": "19981106"
}

```
Response
```json
  "FinCard": "핀-카드",
   "RgsnYmd": "등록번호"
```

## 출금이체 (고객 계좌 -> 핀테크 약정 계좌)
https://developers.nonghyup.com/DrawingTransfer.nh

Request
```json

{
  "Header": {
    "ApiNm": "DrawingTransfer",
    "Tsymd": "20201213",
    "Trtm": "112428",
    "Iscd": "000701",
    "FintechApsno": "001",
    "ApiSvcCd": "DrawingTransferA",
    "IsTuno": "00005",
    "AccessToken": "7e4615cdfe6c788efb282bfad00e78629bb505ba4bc881867121cb92b5b9d8bd"
  },
  "FinAcno": "고객핀어카운트",
  "Tram": "거래금액",
  "DractOtlt": "출금계좌인자내용"
}

```
Response
```json
  "FinAcno": "핀어카운트",
  "RgsnYmd": "등록일자"
```

## 농협입금이체 (핀테크 약정 계좌 -> 농협계좌)
https://developers.nonghyup.com/ReceivedTransferAccountNumber.nh

Request
```json

{
  "Header": {
    "ApiNm": "ReceivedTransferAccountNumber",
    "Tsymd": "20201213",
    "Trtm": "112428",
    "Iscd": "000701",
    "FintechApsno": "001",
    "ApiSvcCd": "ReceivedTransferA",
    "IsTuno": "00006",
    "AccessToken": "7e4615cdfe6c788efb282bfad00e78629bb505ba4bc881867121cb92b5b9d8bd"
  },
  "Bncd": "011",
  "Acno": "농협계좌번호",
  "Tram": "거래금액",
  "DractOtlt": "출금계좌인자내용",
  "MractOtlt": "입금계좌인자내용"
}

```
Response
```json
```

## 타행입금이체 (핀테크 약정 계좌 -> 타행계좌)
https://developers.nonghyup.com/ReceivedTransferOtherBank.nh

Request
```json

{
  "Header": {
    "ApiNm": "ReceivedTransferOtherBank",
    "Tsymd": "20201213",
    "Trtm": "112428",
    "Iscd": "000701",
    "FintechApsno": "001",
    "ApiSvcCd": "ReceivedTransferA",
    "IsTuno": "00007",
    "AccessToken": "7e4615cdfe6c788efb282bfad00e78629bb505ba4bc881867121cb92b5b9d8bd"
  },
  "Bncd": "은행코드",
  "Acno": "타행계좌번호",
  "Tram": "거래금액",
  "DractOtlt": "출금계좌인자내용",
  "MractOtlt": "입금계좌인자내용"
}

```
Response
```json
```

## 개인카드 승인내역조회
https://developers.nonghyup.com/InquireCreditCardAuthorizationHistory.nh

Request
```json

{
  "Header": {
    "ApiNm": "InquireCreditCardAuthorizationHistory",
    "Tsymd": "오늘날짜를입력하세요",
    "Trtm": "112428",
    "Iscd": "기관코드를입력하세요",
    "FintechApsno": "001",
    "ApiSvcCd": "CardInfo",
    "IsTuno": "0000",
    "AccessToken": "인증키를입력하세요"
  },
  "FinCard": "핀카드번호",
  "IousDsnc": "1",
  "Insymd": "조회시작일자",
  "Ineymd": "조회종료일자",
  "PageNo": "1",
  "Dmcnt": "15"
}

```
Response
```json

{
    "Header":{
        "ApiNm":"InquireCorporationCardAuthorizationHistory",
        "Tsymd":"20151014",
        "Trtm":"111045",
        "Iscd":"000013",
        "FintechApsno":"001",
        "ApiSvcCd":"CardInfo",
        "IsTuno":"201510140000000001",
        "Rpcd":"00000",
        "Rsms ":"정상처리되었습니다"
      },
        "PageNo":"1",
        "Dmcnt":"3",
        "CtntDataYn":"연속데이터여부",
        "TotCnt":"총건수",
        "Iqtcnt":"조회총건수"
        "REC":[ 
          {
            "CardAthzNo":"40927800",
            "Trdd":"20191105",
            "Txtm":"154038",
            "Usam":"100",
            "AfstNoBrno":"2936400278",
            "AfstNo":"146862942",
            "AfstNm":"핀테크상사",
            "AmslKnd":"1",
            "Tris":"00",
            "Ccyn":"0",
            "CnclYmd":"",
            "Crcd":"",
            "AcplUsam":""
          },
          {
            "CardAthzNo":"카드승인번호",
            "Trdd":"거래일자",
            "Txtm":"거래시각",
            "Usam":"이용금액",
            "AfstNoBrno":"가맹점사업자등록번호",
            "AfstNo":"가맹점번호",
            "AfstNm":"가맹점명",
            "AmslKnd":"매출종류(1:일시불, 2:할부, 3:현금서비스)", 
            "Tris":"할부시간",
            "Ccyn":"취소여부(0:정상, 1:취소)",
            "CnclYmd":"취소시 취소일자",
            "Crcd":"통화코드",
            "AcplUsam":""
          },
          {
            "CardAthzNo":"41111115",
            "Trdd":"20191109",
            "Txtm":"182000",
            "Usam":"6000",
            "AfstNoBrno":"2936400283",
            "AfstNo":"146862947",
            "AfstNm":"할머니국밥",
            "AmslKnd":"1",
            "Tris":"00",
            "Ccyn":"0",
            "CnclYmd":"",
            "Crcd":"",
            "AcplUsam":""
          }
        ]
}

```
