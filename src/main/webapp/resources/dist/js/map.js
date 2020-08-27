<script>
                  var address =null;
                  function getAddr(){
                      $.ajax({
                            type:'post',
                            headers:{
                                "Content-Type":"application/json"
                            },
                            async :false,// ajax를 동기화(순서대로) 처리해야하는 경우 true로하거나 기술하지 않으면 비동기로 작동한다.
                            url:"/board/category/getAddr?userId=${boardDTO.userId}",
                            dataType:"text",
                            success : function(result){
                                if ( result !=null ){
                                    console.log("넘어온 값 : " + result);
                                    address = result;  
                                }
                            }
                        });
                  };
                  function initMap() {// 지도 요청시 callback으로 호출될 메서드 부분으로 지도를 맨처음 초기화하고, 표시해주는 함수
                    getAddr();
                    var latVal = ${boardDTO.lat};// 게시글 DTO에서 위도값을 가져옴
                    var lngVal = ${boardDTO.lon};// 게시글 DTO에서 경도값을 가져옴
                    var mapLocation = {lat: latVal, lng: lngVal};// 위도, 경도를 가지는 객체를 생성
                /*     var map = new google.maps.Map(document.getElementById('map'), { // 위의 div id="map" 부분에 지도를 추가하는 부분
                      zoom: 18, // 확대 정도(ZOOM)
                      center: uluru // 지도에 표시해주는 중심이 우리가 만든 객체의 위치를 지정해주도록 함
                    });
                     */
                    var mapOptions = {
                            center: mapLocation, // 지도에서 가운데로 위치할 위도와 경도(변수)
                            zoom: 18, // 지도 zoom단계
                            mapTypeId: google.maps.MapTypeId.ROADMAP
                          };
                          var map = new google.maps.Map(document.getElementById("map"), // id: map-canvas, body에 있는 div태그의 id와 같아야 함
                              mapOptions);
                            
                          var size_x = 60; // 마커로 사용할 이미지의 가로 크기
                          var size_y = 60; // 마커로 사용할 이미지의 세로 크기
                            
                          // 마커로 사용할 이미지 주소
                          var image = new google.maps.MarkerImage( 'http://www.weicherthallmark.com/wp-content/themes/realty/lib/images/map-marker/map-marker-gold-fat.png',
                                              new google.maps.Size(size_x, size_y),
                                              '',
                                              '',
                                              new google.maps.Size(size_x, size_y));
                            
                          var marker;
                          marker = new google.maps.Marker({
                                 position: mapLocation, // 마커가 위치할 위도와 경도(변수)
                                 map: map,
                                 icon: image, // 마커로 사용할 이미지(변수)
                                 title: "${boardDTO.userId}(님) 의 거래 희망 위치" // 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
                          });
                            
                          var content = "${boardDTO.userId} 님은 "+address+" 근처에서 거래를 희망합니다."; // 말풍선 안에 들어갈 내용
                            
                          // 마커를 클릭했을 때의 이벤트. 말풍선 뿅~
                          var infowindow = new google.maps.InfoWindow({ content: content});
                    
                          google.maps.event.addListener(marker, "click", function() {
                              infowindow.open(map,marker);
                          });
                            
                    
                    /*
                     단순한 마커로 default로 표시할 때 쓰는 마커 세팅
                    var marker = new google.maps.Marker({
                        position: uluru,
                        map: map
                      });
                     
                     */
                  }
                </script>
                <!--
                    아래는 서버로부터 지도를 로딩하기 위해 요청하는 경로 async는 비동기로 로딩하도록해 지도 로딩 중 다른 웹 부분들이 열릴 수 있도록하기 위함
                    key부분에는 자신의 키를 넣고, 로딩이 완료되면 callback에 지정한 함수를 수행하게 됨.
                 -->
               <script async defer
                                src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap">
                           </script>
                <!-- End of GoogleMap API 연동(황영롱) -->