Shopee Simulator
1. Introduction
Trong thời đại thương mại điện tử phát triển mạnh mẽ, các nền tảng như Shopee đã trở thành một trong những hệ thống mua sắm trực tuyến lớn nhất tại khu vực Đông Nam Á. Với hàng triệu sản phẩm được đăng bán mỗi ngày, việc nghiên cứu, phân tích dữ liệu sản phẩm và tự động hóa các quy trình mua sắm ngày càng trở nên quan trọng đối với các nhà phát triển phần mềm và các nhà nghiên cứu dữ liệu.
Shopee Simulator là một công cụ được thiết kế để mô phỏng các hành vi của người dùng trên hệ thống Shopee. Công cụ này cho phép lập trình viên kiểm tra các chức năng như tìm kiếm sản phẩm, xem chi tiết sản phẩm, lấy dữ liệu giá, thêm sản phẩm vào giỏ hàng hoặc phân tích xu hướng giá mà không cần phải thực hiện các thao tác thủ công trên giao diện trình duyệt.
Mục tiêu chính của Shopee Simulator là tạo ra một môi trường thử nghiệm (testing environment) để các nhà phát triển có thể kiểm tra các thuật toán, bot tự động hoặc hệ thống thu thập dữ liệu một cách hiệu quả. Điều này đặc biệt hữu ích trong các lĩnh vực như web automation, data crawling, price monitoring, và market analysis.
2. Purpose of Shopee Simulator
Shopee Simulator có nhiều mục đích sử dụng trong lĩnh vực phát triển phần mềm và phân tích dữ liệu.
Thứ nhất, simulator giúp lập trình viên mô phỏng hành vi người dùng như tìm kiếm sản phẩm hoặc xem thông tin sản phẩm. Điều này cho phép kiểm thử hệ thống tự động mà không cần phải thao tác trực tiếp trên website.
Thứ hai, simulator có thể được sử dụng để thu thập dữ liệu sản phẩm như tên sản phẩm, giá, đánh giá và số lượng bán ra. Những dữ liệu này có thể được sử dụng để phân tích xu hướng thị trường hoặc xây dựng các hệ thống so sánh giá.
Thứ ba, simulator giúp kiểm tra hiệu suất của các thuật toán tự động. Ví dụ, một bot có thể được thiết kế để tự động tìm sản phẩm có giá thấp nhất hoặc theo dõi sự thay đổi giá theo thời gian.
Nhờ khả năng mô phỏng các request giống với trình duyệt thật, Shopee Simulator có thể gửi các yêu cầu HTTP tới server của Shopee và nhận lại dữ liệu ở dạng JSON. Sau đó dữ liệu này có thể được xử lý bằng các ngôn ngữ lập trình như Python, JavaScript hoặc Java.
3. How Shopee Simulator Works
Shopee Simulator hoạt động dựa trên nguyên lý gửi các HTTP request đến các API endpoint của Shopee. Khi người dùng tìm kiếm sản phẩm trên Shopee, trình duyệt sẽ gửi một request đến server để lấy danh sách sản phẩm phù hợp với từ khóa tìm kiếm. Simulator sẽ mô phỏng chính request này.
Quá trình hoạt động cơ bản của Shopee Simulator bao gồm các bước sau:
Người dùng nhập từ khóa tìm kiếm (ví dụ: laptop, iphone, tai nghe).
Simulator gửi request HTTP đến API tìm kiếm của Shopee.
Server của Shopee trả về dữ liệu sản phẩm dưới dạng JSON.
Simulator xử lý dữ liệu và hiển thị thông tin sản phẩm.
Thông tin sản phẩm có thể bao gồm:
Tên sản phẩm
Giá sản phẩm
Số lượng đã bán
Đánh giá của người dùng
Thông tin shop
Những dữ liệu này sau đó có thể được sử dụng cho nhiều mục đích khác nhau như phân tích dữ liệu hoặc xây dựng hệ thống khuyến nghị sản phẩm.
4. Example Code (Python)
Dưới đây là một ví dụ đơn giản về cách xây dựng một Shopee Simulator bằng Python để tìm kiếm sản phẩm trên Shopee.
import requests

url = "https://shopee.vn/api/v4/search/search_items"

params = {
    "by": "relevancy",
    "keyword": "laptop",
    "limit": 10,
    "newest": 0,
    "order": "desc",
    "page_type": "search"
}

headers = {
    "User-Agent": "Mozilla/5.0",
    "Accept": "application/json"
}

response = requests.get(url, params=params, headers=headers)

data = response.json()

for item in data["items"]:
    product = item["item_basic"]["name"]
    price = item["item_basic"]["price"] / 100000
    sold = item["item_basic"]["historical_sold"]

    print("Product:", product)
    print("Price:", price, "VND")
    print("Sold:", sold)
    print("----------------------")
5. Code Explanation
Trong đoạn code trên, thư viện requests được sử dụng để gửi HTTP request đến API của Shopee.
url là endpoint API được dùng để tìm kiếm sản phẩm.
params chứa các tham số tìm kiếm như từ khóa (keyword) và số lượng sản phẩm cần trả về (limit).
headers mô phỏng thông tin của trình duyệt để server nhận diện request giống như request từ người dùng thật.
Sau khi gửi request, server sẽ trả về dữ liệu ở dạng JSON. Chương trình sẽ đọc dữ liệu này và trích xuất các thông tin như tên sản phẩm, giá và số lượng đã bán.
Nhờ cách này, simulator có thể tự động thu thập thông tin sản phẩm mà không cần mở website bằng trình duyệt.
6. Advantages of Shopee Simulator
Shopee Simulator mang lại nhiều lợi ích cho lập trình viên và nhà phân tích dữ liệu.
Thứ nhất, nó giúp tiết kiệm thời gian khi thu thập dữ liệu sản phẩm từ Shopee. Thay vì phải tìm kiếm thủ công từng sản phẩm, simulator có thể tự động thu thập hàng trăm hoặc hàng nghìn sản phẩm trong thời gian ngắn.
Thứ hai, simulator cho phép kiểm thử các thuật toán tự động trong môi trường mô phỏng. Điều này giúp giảm rủi ro khi triển khai các hệ thống automation trong thực tế.
Thứ ba, simulator có thể được tích hợp vào các hệ thống phân tích dữ liệu lớn để theo dõi xu hướng giá hoặc dự đoán nhu cầu thị trường.
7. Conclusion
Shopee Simulator là một công cụ hữu ích trong việc nghiên cứu và phát triển các hệ thống tự động liên quan đến thương mại điện tử. Bằng cách mô phỏng hành vi người dùng và gửi các request HTTP tới API của Shopee, simulator cho phép lập trình viên thu thập dữ liệu sản phẩm, kiểm thử thuật toán và xây dựng các hệ thống phân tích thị trường.
Trong tương lai, các công cụ mô phỏng như Shopee Simulator có thể được phát triển thêm để hỗ trợ nhiều chức năng phức tạp hơn, chẳng hạn như mô phỏng quá trình mua hàng hoàn chỉnh, theo dõi sự thay đổi giá theo thời gian hoặc xây dựng các hệ thống khuyến nghị sản phẩm thông minh.
Phân tích lỗi đăng nhập trong hệ thống
Sau khi kiểm tra quá trình đăng ký và đăng nhập của hệ thống, có thể xác định nguyên nhân khiến người dùng đăng nhập không thành công nằm ở sự không đồng nhất trong quá trình xử lý mật khẩu.
Trong chức năng đăng ký tài khoản (Register), mật khẩu người dùng nhập vào đã được mã hóa bằng thuật toán MD5 trước khi lưu vào cơ sở dữ liệu. Điều này có nghĩa là trong bảng database, giá trị được lưu trữ không phải là mật khẩu gốc mà là chuỗi hash MD5 của mật khẩu.
Tuy nhiên, trong chức năng đăng nhập (Login), chương trình lại lấy trực tiếp mật khẩu người dùng nhập từ form và truyền thẳng vào hàm login() trong UserDAO để so sánh với dữ liệu trong database. Do mật khẩu trong database đã được mã hóa, còn mật khẩu gửi từ form lại là dạng văn bản gốc (plain text), nên hai giá trị này không bao giờ trùng nhau. Vì vậy truy vấn SQL dạng:
SELECT * FROM Users 
WHERE email = ? AND password_hash = ?
luôn trả về kết quả rỗng, khiến hệ thống xác định đăng nhập thất bại.
Cách khắc phục
Để giải quyết vấn đề này, cần đảm bảo rằng mật khẩu khi đăng nhập cũng phải được mã hóa bằng cùng thuật toán MD5 trước khi so sánh với dữ liệu trong database.
Cụ thể, trong LoginServlet, sau khi nhận mật khẩu từ form:
String p = request.getParameter("pass");
ta cần gọi hàm mã hóa MD5 để tạo ra chuỗi hash tương ứng:
String passHash = getMd5(p);
Sau đó truyền giá trị passHash vào phương thức login() thay vì truyền mật khẩu gốc:
User account = dao.login(u, passHash);
Như vậy, mật khẩu được dùng để so sánh với database sẽ có cùng định dạng (đều là MD5), giúp hệ thống xác thực người dùng chính xác.
Một số điểm cần kiểm tra thêm
Ngoài lỗi chính về mã hóa mật khẩu, còn một số yếu tố có thể gây lỗi đăng nhập:
Tên tham số trong form JSP
Trong login.jsp, các ô nhập liệu phải có thuộc tính name trùng với tên được lấy trong Servlet. Ví dụ:
<input type="text" name="user">
<input type="password" name="pass">
Nếu tên này không khớp với:
request.getParameter("user");
request.getParameter("pass");
thì dữ liệu nhận được sẽ là null.
Thư viện Servlet phải đồng nhất
Dự án cần sử dụng cùng một chuẩn thư viện:
Nếu dùng Tomcat 9 trở xuống → javax.servlet
Nếu dùng Tomcat 10 trở lên → jakarta.servlet
Việc trộn lẫn hai thư viện này có thể khiến server báo lỗi hoặc servlet không hoạt động đúng.
Kết luận
Nguyên nhân chính khiến hệ thống không đăng nhập được là do mật khẩu khi đăng nhập chưa được mã hóa trước khi so sánh với dữ liệu đã mã hóa trong database. Sau khi bổ sung bước mã hóa MD5 trong LoginServlet và kiểm tra lại tên tham số trong form, chức năng đăng nhập sẽ hoạt động bình thường.

Trong quá trình kiểm tra chức năng đăng nhập của hệ thống, có thể nhận thấy rằng người dùng đã đăng ký tài khoản thành công nhưng lại không thể đăng nhập vào hệ thống. Sau khi xem xét các thành phần liên quan như RegisterServlet, LoginServlet, UserDAO và dữ liệu trong database, nguyên nhân chính của lỗi này được xác định là sự không nhất quán trong quá trình xử lý mật khẩu giữa chức năng đăng ký và đăng nhập.
1. Cách hệ thống xử lý mật khẩu khi đăng ký
Trong chức năng đăng ký tài khoản, khi người dùng nhập mật khẩu vào form đăng ký, hệ thống không lưu trực tiếp mật khẩu gốc vào cơ sở dữ liệu. Thay vào đó, chương trình sử dụng thuật toán băm MD5 để chuyển mật khẩu sang dạng chuỗi hash trước khi lưu trữ.
Quá trình này thường được thực hiện thông qua một hàm như sau:

private String getMd5(String input)
Hàm này sử dụng lớp MessageDigest của Java để tạo ra giá trị MD5 của chuỗi đầu vào. Sau khi mật khẩu được băm, hệ thống sẽ lưu chuỗi hash này vào database thay vì mật khẩu gốc.
Ví dụ:

Người dùng nhập mật khẩu:
123
Sau khi mã hóa MD5:
202cb962ac59075b964b07152d234b70
Chuỗi MD5 này sẽ được lưu trong cột password_hash của bảng Users.
Việc sử dụng cơ chế hash mật khẩu giúp tăng mức độ bảo mật cho hệ thống, vì ngay cả khi database bị truy cập trái phép, hacker cũng không thể nhìn thấy mật khẩu gốc của người dùng.

2. Lỗi xảy ra trong chức năng đăng nhập
Trong chức năng đăng nhập, hệ thống nhận thông tin từ form login.jsp, bao gồm:
Tên đăng nhập hoặc email
Mật khẩu
Dữ liệu này được gửi tới LoginServlet thông qua phương thức POST. Sau đó, servlet sẽ lấy dữ liệu từ request bằng cách sử dụng:
String u = request.getParameter("user");
String p = request.getParameter("pass");
Vấn đề nằm ở chỗ: mật khẩu p ở đây vẫn là mật khẩu gốc do người dùng nhập, chưa được mã hóa. Tuy nhiên trong database, mật khẩu đã được lưu dưới dạng chuỗi MD5.
Sau đó chương trình gọi hàm:

User account = dao.login(u, p);
Trong UserDAO, phương thức login() thường thực hiện truy vấn SQL như sau:
SELECT * FROM Users 
WHERE email = ? AND password_hash = ?
Do giá trị p là mật khẩu gốc (ví dụ: 123), trong khi database lưu 202cb962ac59075b964b07152d234b70, nên hai giá trị này không bao giờ trùng nhau. Kết quả là truy vấn SQL không tìm thấy bản ghi phù hợp và trả về null.
Vì vậy, hệ thống luôn cho rằng tài khoản hoặc mật khẩu không chính xác, dù người dùng nhập đúng thông tin.

3. Giải pháp khắc phục
Để khắc phục lỗi này, cần đảm bảo rằng mật khẩu nhập vào trong quá trình đăng nhập được mã hóa bằng cùng thuật toán MD5 trước khi thực hiện truy vấn database.
Trong LoginServlet, sau khi nhận mật khẩu từ request, cần thêm bước mã hóa:

String passHash = getMd5(p);
Sau đó truyền giá trị đã mã hóa vào DAO:
User account = dao.login(u, passHash);
Như vậy quá trình so sánh sẽ diễn ra giữa hai chuỗi MD5 giống nhau, giúp hệ thống xác thực chính xác tài khoản người dùng.
Quy trình đăng nhập sau khi sửa sẽ hoạt động như sau:

Người dùng nhập email và mật khẩu.
Servlet nhận dữ liệu từ form.
Mật khẩu được mã hóa bằng MD5.
Hệ thống gửi email và chuỗi MD5 đến UserDAO.
Database kiểm tra dữ liệu.
Nếu tồn tại bản ghi phù hợp → đăng nhập thành công.
4. Kiểm tra sự khớp giữa form JSP và Servlet
Một vấn đề khác có thể gây lỗi là tên tham số trong form không khớp với Servlet.
Trong file login.jsp, form nhập liệu được định nghĩa như sau:

<input type="text" name="user">
<input type="password" name="pass">
Do đó trong Servlet phải lấy đúng tên tham số:
request.getParameter("user");
request.getParameter("pass");
Nếu JSP sử dụng tên khác (ví dụ email hoặc password), thì biến nhận dữ liệu trong Servlet sẽ bị null, dẫn đến đăng nhập thất bại.
5. Kiểm tra phiên bản thư viện Servlet
Một lỗi tiềm ẩn khác liên quan đến sự không đồng nhất giữa thư viện javax.servlet và jakarta.servlet.
Nếu project chạy trên Tomcat 9 hoặc thấp hơn, phải dùng:
import javax.servlet.*;
Nếu project chạy trên Tomcat 10 trở lên, phải dùng:
import jakarta.servlet.*;
Việc sử dụng lẫn lộn hai thư viện này có thể gây ra lỗi server hoặc khiến servlet không được nhận diện.
6. Kết luận
Nguyên nhân chính khiến hệ thống không thể đăng nhập là do mật khẩu được mã hóa khi đăng ký nhưng lại không được mã hóa khi đăng nhập, dẫn đến sự sai lệch trong quá trình so sánh dữ liệu với database.
Sau khi bổ sung bước mã hóa MD5 trong LoginServlet, đồng thời kiểm tra lại tên tham số trong form JSP và đảm bảo sử dụng đúng thư viện Servlet, chức năng đăng nhập sẽ hoạt động chính xác.

Việc áp dụng cơ chế hash mật khẩu không chỉ giúp hệ thống hoạt động đúng mà còn nâng cao mức độ bảo mật cho ứng dụng web, bảo vệ thông tin người dùng trước các rủi ro về an toàn dữ liệu.
Phân tích chi tiết cơ chế đăng nhập và lỗi xác thực mật khẩu trong hệ thống Web
1. Tổng quan về chức năng đăng nhập trong ứng dụng web
Trong hầu hết các hệ thống thương mại điện tử như Shopee, Lazada hoặc Amazon, chức năng đăng ký và đăng nhập tài khoản là một trong những thành phần quan trọng nhất của hệ thống. Nó cho phép hệ thống xác định danh tính của người dùng và cung cấp các chức năng cá nhân hóa như quản lý giỏ hàng, đặt hàng, thanh toán và theo dõi đơn hàng.
Trong project web mô phỏng Shopee, quá trình đăng nhập được xây dựng dựa trên mô hình Java Web Application, bao gồm các thành phần chính:
Frontend (JSP/HTML/CSS/JS): giao diện cho người dùng nhập thông tin
Servlet (Controller): xử lý request từ người dùng
DAO (Data Access Object): giao tiếp với cơ sở dữ liệu
Database: lưu trữ thông tin người dùng
Quá trình đăng nhập thông thường sẽ trải qua các bước sau:
Người dùng nhập email (hoặc username) và mật khẩu vào form đăng nhập.
Form gửi dữ liệu đến LoginServlet thông qua phương thức POST.
Servlet nhận dữ liệu và xử lý logic xác thực.
Servlet gọi UserDAO để kiểm tra thông tin trong database.
Nếu dữ liệu hợp lệ, hệ thống tạo Session để lưu trạng thái đăng nhập.
Người dùng được chuyển hướng đến trang chủ.
Tuy nhiên, trong hệ thống hiện tại đã xuất hiện lỗi khiến người dùng không thể đăng nhập dù đã đăng ký thành công.
2. Phân tích nguyên nhân gây lỗi đăng nhập
Sau khi kiểm tra mã nguồn của RegisterServlet, LoginServlet và cấu trúc database, có thể xác định nguyên nhân chính là sự không đồng bộ trong cách xử lý mật khẩu giữa hai chức năng đăng ký và đăng nhập.
2.1 Mật khẩu được mã hóa khi đăng ký
Trong chức năng đăng ký, hệ thống đã áp dụng thuật toán băm MD5 để mã hóa mật khẩu trước khi lưu vào database.
Ví dụ:
Người dùng nhập mật khẩu:
123456
Sau khi áp dụng thuật toán MD5, mật khẩu sẽ trở thành:
e10adc3949ba59abbe56e057f20f883e
Database sẽ lưu chuỗi này vào cột password_hash.
Cách làm này có lợi ích lớn về bảo mật, vì:
Database không lưu mật khẩu gốc
Nếu dữ liệu bị rò rỉ, hacker không thể biết mật khẩu thật của người dùng
Đây là một nguyên tắc cơ bản trong bảo mật ứng dụng web.
3. Vấn đề trong quá trình đăng nhập
Trong chức năng đăng nhập, hệ thống nhận dữ liệu từ form login.jsp.
Form gửi hai tham số chính:
user
pass
Servlet sẽ nhận dữ liệu bằng phương thức:
String u = request.getParameter("user");
String p = request.getParameter("pass");
Tuy nhiên biến p ở đây vẫn là mật khẩu gốc do người dùng nhập, chưa được mã hóa.
Sau đó chương trình gọi DAO:
User account = dao.login(u, p);
Trong DAO, truy vấn SQL thường có dạng:
SELECT * FROM Users
WHERE email = ? AND password_hash = ?
Do database đang lưu chuỗi MD5, còn biến p lại là mật khẩu gốc, nên hai giá trị này không bao giờ giống nhau.
Ví dụ:
Giá trị	Nội dung
Mật khẩu nhập	123456
Mật khẩu trong DB	e10adc3949ba59abbe56e057f20f883e
Kết quả:
SQL không tìm thấy bản ghi
DAO trả về null
Servlet hiểu rằng đăng nhập thất bại
4. Giải pháp sửa lỗi
Để hệ thống hoạt động chính xác, cần đảm bảo quy trình xử lý mật khẩu phải giống nhau ở cả đăng ký và đăng nhập.
Cụ thể:
Khi người dùng nhập mật khẩu trong form đăng nhập
Servlet phải mã hóa mật khẩu bằng MD5
Sau đó mới gửi chuỗi hash vào DAO
Ví dụ:
String passHash = getMd5(p);
User account = dao.login(u, passHash);
Khi đó quá trình so sánh sẽ diễn ra như sau:
So sánh	Giá trị
Database	e10adc3949ba59abbe56e057f20f883e
Servlet	e10adc3949ba59abbe56e057f20f883e
Kết quả:
SQL tìm thấy bản ghi
DAO trả về User
Đăng nhập thành công
5. Quản lý phiên đăng nhập (Session)
Sau khi xác thực thành công, hệ thống cần lưu thông tin người dùng vào Session để duy trì trạng thái đăng nhập.
Ví dụ:
HttpSession session = request.getSession();
session.setAttribute("account", account);
Session sẽ cho phép hệ thống:
Nhận biết người dùng đã đăng nhập
Hiển thị thông tin cá nhân
Quản lý giỏ hàng
Thực hiện đặt hàng
Nếu không có Session, mỗi request gửi lên server sẽ bị coi như một người dùng mới.
6. Các lỗi phổ biến khác có thể xảy ra
Ngoài lỗi mã hóa mật khẩu, còn nhiều yếu tố khác có thể gây lỗi đăng nhập.
6.1 Sai tên tham số trong form
Nếu form JSP đặt tên input khác với Servlet, dữ liệu sẽ bị null.
Ví dụ:
<input name="email">
nhưng Servlet lại dùng:
request.getParameter("user")
khi đó biến u sẽ bị rỗng.
6.2 Không đồng bộ thư viện Servlet
Java Web có hai chuẩn:
Tomcat 9 trở xuống
javax.servlet
Tomcat 10 trở lên
jakarta.servlet
Nếu project dùng lẫn lộn hai chuẩn này, server có thể báo lỗi HTTP 500 hoặc không nhận diện được servlet.
7. Cải thiện bảo mật cho hệ thống
Mặc dù MD5 được sử dụng phổ biến trước đây, nhưng trong các hệ thống hiện đại, MD5 không còn được khuyến khích vì có thể bị tấn công brute-force.
Các hệ thống lớn hiện nay thường sử dụng:
BCrypt
PBKDF2
SHA-256 + Salt
Các thuật toán này giúp tăng độ khó khi hacker cố gắng giải mã mật khẩu.
Ví dụ:
Shopee, Facebook hay Google đều sử dụng hash + salt + nhiều vòng mã hóa để bảo vệ dữ liệu người dùng.
8. Kết luận
Từ quá trình phân tích trên, có thể kết luận rằng lỗi đăng nhập trong hệ thống xuất phát từ sự không đồng nhất trong quá trình mã hóa mật khẩu giữa chức năng đăng ký và đăng nhập. Khi đăng ký, mật khẩu đã được mã hóa bằng MD5 trước khi lưu vào database, nhưng khi đăng nhập lại sử dụng mật khẩu gốc để so sánh. Điều này dẫn đến việc truy vấn SQL không tìm thấy bản ghi phù hợp và hệ thống luôn trả về kết quả đăng nhập thất bại.
Sau khi bổ sung bước mã hóa mật khẩu trong LoginServlet, đồng thời kiểm tra lại tên tham số trong form JSP và cấu hình thư viện servlet, hệ thống có thể xác thực người dùng chính xác và chức năng đăng nhập sẽ hoạt động bình thường.
Ngoài ra, để nâng cao mức độ an toàn cho ứng dụng web, trong tương lai hệ thống có thể thay thế MD5 bằng các thuật toán băm hiện đại như BCrypt hoặc SHA-256, giúp bảo vệ dữ liệu người dùng tốt
Hoàn thiện và bảo vệ hệ thống Shopee Web Clone
1. Tổng quan giai đoạn hoàn thiện dự án
Sau khi hoàn thành các chức năng chính của hệ thống như đăng ký, đăng nhập, quản lý giỏ hàng, đặt hàng, kiểm tra tồn kho và xử lý đồng bộ khi có nhiều người mua cùng lúc, giai đoạn cuối của dự án tập trung vào việc hoàn thiện sản phẩm, tối ưu trải nghiệm người dùng và chuẩn bị cho buổi bảo vệ đồ án.
Ở giai đoạn này, hệ thống không chỉ cần hoạt động đúng về mặt chức năng mà còn cần đảm bảo:
Giao diện rõ ràng và dễ sử dụng
Hệ thống có thể xử lý nhiều request đồng thời
Dữ liệu được quản lý ổn định và có thể reset nhanh
Có báo cáo thống kê trực quan
Sản phẩm có thể đóng gói và triển khai trên server
Toàn bộ các yếu tố trên giúp hệ thống đạt tiêu chuẩn của một ứng dụng web hoàn chỉnh.
2. Kiến trúc hệ thống của project
Dự án Shopee Web Clone được xây dựng dựa trên mô hình MVC (Model – View – Controller) trong Java Web.
2.1 Model (Data Layer)
Tầng Model chịu trách nhiệm quản lý dữ liệu và giao tiếp với database. Các lớp trong tầng này thường bao gồm:
User
Product
ProductVariant
Order
Cart
CartItem
Ngoài ra còn có các lớp DAO (Data Access Object) như:
UserDAO
ProductDAO
OrderDAO
StatsDAO
Các DAO này thực hiện nhiệm vụ:
Truy vấn dữ liệu từ database
Thêm, sửa, xóa dữ liệu
Thực hiện các phép thống kê
Ví dụ:
SELECT * FROM Users
SELECT * FROM Products
SELECT SUM(total_amount) FROM Orders
Việc tách DAO giúp code dễ bảo trì và tái sử dụng.
2.2 Controller (Servlet Layer)
Tầng Controller sử dụng Servlet để xử lý request từ người dùng.
Một số servlet chính trong hệ thống:
RegisterServlet
LoginServlet
HomeServlet
BuyNowServlet
CartServlet
AdminServlet
AdminImportServlet
StressTestServlet
Servlet đóng vai trò như bộ điều khiển trung tâm.
Quy trình xử lý request:
Người dùng gửi request từ trình duyệt
Servlet nhận request
Servlet xử lý logic
Gọi DAO để truy xuất dữ liệu
Trả kết quả về JSP
Ví dụ:
UserDAO dao = new UserDAO();
User user = dao.login(email, passwordHash);
Sau đó servlet chuyển dữ liệu sang JSP bằng:
request.setAttribute("account", user);
2.3 View (Giao diện JSP)
Tầng View sử dụng JSP + HTML + CSS + JavaScript để hiển thị giao diện cho người dùng.
Một số trang quan trọng:
home.jsp
login.jsp
register.jsp
cart.jsp
admin.jsp
admin_import.jsp
Các trang này được thiết kế với Bootstrap 5 để đảm bảo giao diện hiện đại và responsive.
Ngoài ra hệ thống còn sử dụng Chart.js để vẽ biểu đồ doanh thu và thống kê đơn hàng trong trang Admin Dashboard.
3. Hệ thống Import dữ liệu (Migration System)
Để phục vụ việc demo và kiểm thử hệ thống, project có chức năng Import dữ liệu tự động từ file CSV.
Trang quản trị cho phép admin:
Reset toàn bộ database
Import dữ liệu mẫu
Làm sạch dữ liệu
Hiển thị log quá trình xử lý
Ví dụ log hiển thị:
> Starting database reset...
> Deleting old data...
> Importing Users (10000 rows)...
> Importing Products (5000 rows)...
> Importing Orders...
> Import completed successfully!
Chức năng này giúp:
Demo hệ thống nhanh
Tạo dữ liệu test lớn
Tránh lỗi dữ liệu cũ
4. Kiểm tra khả năng chịu tải (Stress Test)
Một điểm nổi bật của project là chức năng Stress Test để mô phỏng Flash Sale.
Trong thực tế, các trang thương mại điện tử thường gặp tình trạng:
Nhiều người mua cùng lúc
Tồn kho bị âm
Hệ thống xử lý sai dữ liệu
Để mô phỏng tình huống này, project sử dụng một tool riêng gọi là ShopeeAttacker.
Tool này tạo ra nhiều luồng (threads) gửi request mua hàng đồng thời.
Ví dụ:
Thread 1 -> buy
Thread 2 -> buy
Thread 3 -> buy
...
Thread 50 -> buy
Nếu hệ thống không có cơ chế bảo vệ, kết quả có thể như sau:
Stock ban đầu = 1
50 người mua cùng lúc
Stock sau cùng = -49
Đây là lỗi Race Condition.
5. Giải pháp xử lý Race Condition
Để khắc phục lỗi này, hệ thống áp dụng cơ chế synchronized trong Java.
Ví dụ:
protected synchronized void doGet(...)
Cơ chế này đảm bảo:
Chỉ một thread được truy cập vào đoạn code tại một thời điểm
Các request khác phải chờ
Kết quả:
Stock ban đầu = 1
50 request cùng lúc
Chỉ 1 request mua thành công
Stock sau cùng = 0
Điều này đảm bảo dữ liệu luôn chính xác và hệ thống không bị lỗi tồn kho âm.
6. Dashboard quản trị (Admin Dashboard)
Trang Admin Dashboard giúp quản trị viên theo dõi tình trạng hoạt động của hệ thống.
Trang này hiển thị:
Tổng doanh thu
Tổng số đơn hàng
Tổng số khách hàng
Biểu đồ doanh thu theo ngày
Biểu đồ được vẽ bằng thư viện Chart.js.
Ví dụ:
Thứ 2: 1.5 triệu
Thứ 3: 2.3 triệu
Thứ 4: 1.8 triệu
Thứ 5: 3.2 triệu
Thứ 6: 2.1 triệu
Thứ 7: 1.1 triệu
CN: 4.5 triệu
Nhờ vậy admin có thể:
Theo dõi doanh thu
Phân tích xu hướng bán hàng
Quản lý hoạt động kinh doanh
7. Đóng gói hệ thống (.WAR)
Sau khi hoàn thành dự án, hệ thống được đóng gói thành file WAR (Web Application Archive).
File WAR chứa:
Source code
JSP
Servlet
Thư viện
Cấu hình web
Cách tạo file WAR trong NetBeans:
Chuột phải vào project
Chọn Clean and Build
NetBeans tự động tạo file trong thư mục:
dist/ShopeeWeb.war
File này có thể deploy trực tiếp lên:
Apache Tomcat
Linux Server
Cloud Server
8. Quy trình demo khi bảo vệ đồ án
Trong buổi bảo vệ, hệ thống được demo theo trình tự sau:
Bước 1 – Import dữ liệu
Admin truy cập:
/admin-import
Sau đó bấm nút:
BẮT ĐẦU IMPORT NGAY
Hệ thống reset database và nạp dữ liệu mới.
Bước 2 – Trải nghiệm người dùng
Chuyển sang trang chủ:
/home
Thực hiện các thao tác:
Xem sản phẩm
Thêm vào giỏ hàng
Thanh toán
Tạo đơn hàng
Bước 3 – Stress Test
Mở tool tấn công và chạy nhiều request cùng lúc.
Sau đó kiểm tra database:
SELECT stock FROM ProductVariants WHERE id = 1
Kết quả:
Stock = 0
Điều này chứng minh hệ thống xử lý đồng bộ chính xác.
Bước 4 – Xem báo cáo
Admin truy cập:
/admin
Trang Dashboard hiển thị:
Doanh thu
Biểu đồ
Thống kê hệ thống
9. Kết luận
Dự án Shopee Web Clone đã xây dựng thành công một hệ thống thương mại điện tử cơ bản với đầy đủ các chức năng quan trọng như:
Quản lý người dùng
Quản lý sản phẩm
Giỏ hàng
Đặt hàng
Quản trị hệ thống
Thống kê doanh thu
Kiểm thử chịu tải
Ngoài ra, hệ thống còn triển khai cơ chế xử lý đồng bộ để tránh lỗi Race Condition, giúp đảm bảo tính chính xác của dữ liệu khi nhiều người dùng truy cập cùng lúc.
Việc đóng gói hệ thống thành file WAR giúp ứng dụng có thể triển khai dễ dàng trên server thực tế.
Dự án này không chỉ giúp hiểu rõ cách xây dựng một ứng dụng web bằng Java Servlet và JSP, mà còn cung cấp kinh nghiệm thực tế về thiết kế hệ thống, tối ưu hiệu năng và xử lý các tình huống phức tạp trong môi trường nhiều người dùng.
> Phân tích luồng xử lý hệ thống trong Shopee Web Clone
1. Luồng xử lý request trong hệ thống web
Trong một ứng dụng web, mọi thao tác của người dùng đều được gửi đến server dưới dạng HTTP Request. Khi người dùng nhấn một nút, mở trang hoặc thực hiện hành động nào đó, trình duyệt sẽ gửi yêu cầu đến server để xử lý.
Trong dự án Shopee Web Clone, luồng xử lý request được thực hiện theo mô hình sau:
Browser → Servlet (Controller) → DAO → Database → JSP → Browser
Quy trình này có thể được mô tả chi tiết như sau:
Người dùng thực hiện hành động trên giao diện (ví dụ: nhấn nút mua hàng).
Trình duyệt gửi request đến server thông qua URL.
Servlet nhận request và xử lý logic.
Servlet gọi DAO để truy vấn hoặc cập nhật dữ liệu trong database.
Database trả dữ liệu về DAO.
DAO trả kết quả về Servlet.
Servlet chuyển dữ liệu sang trang JSP để hiển thị.
JSP tạo HTML và gửi lại cho trình duyệt.
Ví dụ khi người dùng truy cập trang chủ:
Browser → /home → HomeServlet → ProductDAO → Database → home.jsp → Browser
Quy trình này giúp tách biệt rõ ràng giữa:
phần giao diện
phần xử lý logic
phần quản lý dữ liệu
Nhờ đó hệ thống dễ bảo trì và mở rộng.
2. Cơ chế quản lý phiên đăng nhập (Session Management)
Trong ứng dụng web, giao thức HTTP là stateless, nghĩa là server không tự động nhớ người dùng là ai giữa các request khác nhau. Vì vậy hệ thống cần sử dụng Session để lưu trạng thái đăng nhập.
Khi người dùng đăng nhập thành công, hệ thống sẽ tạo một session mới:
HttpSession session = request.getSession();
session.setAttribute("account", user);
Session này sẽ lưu thông tin của người dùng trong suốt quá trình sử dụng hệ thống.
Sau đó khi người dùng truy cập các trang khác, server có thể kiểm tra session:
User user = (User) session.getAttribute("account");
Nếu session tồn tại, hệ thống biết rằng người dùng đã đăng nhập.
Session được sử dụng cho nhiều chức năng quan trọng như:
xác định người dùng hiện tại
lưu giỏ hàng
kiểm tra quyền admin
bảo vệ các trang quản trị
Nếu session hết hạn hoặc người dùng đăng xuất, session sẽ bị xóa:
session.invalidate();
Điều này đảm bảo tính bảo mật cho hệ thống.
3. Cơ chế hoạt động của giỏ hàng (Shopping Cart)
Giỏ hàng là một chức năng quan trọng trong hệ thống thương mại điện tử. Nó cho phép người dùng thêm nhiều sản phẩm trước khi thực hiện thanh toán.
Trong project này, giỏ hàng được quản lý thông qua Session.
Khi người dùng thêm sản phẩm vào giỏ, hệ thống thực hiện các bước:
Lấy giỏ hàng hiện tại từ session
Nếu chưa có thì tạo mới
Thêm sản phẩm vào danh sách
Lưu lại vào session
Ví dụ:
Cart cart = (Cart) session.getAttribute("cart");
Nếu cart là null, hệ thống sẽ tạo giỏ mới:
cart = new Cart();
Sau đó thêm sản phẩm:
cart.addItem(product, quantity);
Cuối cùng lưu lại:
session.setAttribute("cart", cart);
Cách làm này giúp giỏ hàng tồn tại trong suốt phiên làm việc của người dùng.
4. Quy trình đặt hàng (Checkout Process)
Khi người dùng hoàn tất việc chọn sản phẩm trong giỏ hàng, họ có thể tiến hành đặt hàng.
Quy trình checkout trong hệ thống được thực hiện theo các bước sau:
Bước 1: Người dùng nhấn nút thanh toán
Request được gửi đến:
/checkout
Bước 2: Servlet kiểm tra session
Hệ thống kiểm tra:
người dùng đã đăng nhập chưa
giỏ hàng có sản phẩm không
Bước 3: Tạo đơn hàng
Servlet gọi OrderDAO để tạo một bản ghi mới trong bảng Orders.
Ví dụ:
INSERT INTO Orders(user_id, total_amount, order_date)
Bước 4: Lưu chi tiết đơn hàng
Mỗi sản phẩm trong giỏ hàng sẽ được lưu vào bảng OrderItems.
INSERT INTO OrderItems(order_id, product_id, quantity, price)
Bước 5: Cập nhật tồn kho
Sau khi đặt hàng thành công, hệ thống giảm số lượng tồn kho:
UPDATE ProductVariants
SET stock = stock - quantity
Bước 6: Xóa giỏ hàng
Sau khi đặt hàng thành công, giỏ hàng sẽ được xóa khỏi session để chuẩn bị cho đơn hàng mới.
5. Hệ thống quản trị (Admin System)
Trong project Shopee Web Clone, hệ thống còn có một phần dành cho quản trị viên.
Trang admin cho phép quản trị viên:
xem thống kê hệ thống
quản lý sản phẩm
theo dõi đơn hàng
xem doanh thu
Admin Dashboard hiển thị các thông tin quan trọng như:
tổng số người dùng
tổng số đơn hàng
tổng doanh thu
biểu đồ doanh thu theo ngày
Những dữ liệu này được truy vấn từ database thông qua StatsDAO.
Ví dụ truy vấn tổng doanh thu:
SELECT SUM(total_amount) FROM Orders
Dữ liệu sau đó được hiển thị bằng biểu đồ Chart.js, giúp admin dễ dàng theo dõi hoạt động kinh doanh.
6. Ý nghĩa thực tiễn của dự án
Dự án Shopee Web Clone không chỉ đơn thuần là một bài tập lập trình mà còn giúp sinh viên hiểu rõ cách xây dựng một hệ thống thương mại điện tử thực tế.
Thông qua dự án này, sinh viên có thể học được:
6.1 Thiết kế hệ thống web
Sinh viên hiểu cách tổ chức project theo mô hình MVC, giúp tách biệt logic xử lý, giao diện và dữ liệu.
6.2 Làm việc với database
Project giúp sinh viên thực hành:
thiết kế bảng dữ liệu
viết câu lệnh SQL
tối ưu truy vấn
6.3 Xử lý nhiều người dùng
Thông qua phần Stress Test, sinh viên hiểu được các vấn đề thực tế như:
race condition
đồng bộ dữ liệu
xử lý request đồng thời
6.4 Phát triển ứng dụng hoàn chỉnh
Sinh viên trải nghiệm toàn bộ quy trình phát triển phần mềm:
phân tích yêu cầu
thiết kế hệ thống
lập trình
kiểm thử
triển khai
Đây là những kỹ năng rất quan trọng trong ngành Software Engineering.
7. Tổng kết
Dự án Shopee Web Clone đã xây dựng thành công một hệ thống thương mại điện tử cơ bản với đầy đủ các chức năng như đăng ký, đăng nhập, quản lý sản phẩm, giỏ hàng và đặt hàng. Hệ thống được phát triển dựa trên kiến trúc MVC, sử dụng Java Servlet, JSP và MySQL để xử lý dữ liệu.
Bên cạnh đó, dự án còn triển khai các cơ chế quan trọng như quản lý session, xử lý đồng bộ khi nhiều người dùng truy cập cùng lúc và xây dựng hệ thống thống kê dành cho quản trị viên. Những tính năng này giúp hệ thống hoạt động ổn định và mô phỏng được cách hoạt động của các nền tảng thương mại điện tử thực tế.
Thông qua việc thực hiện dự án này, sinh viên không chỉ nâng cao kỹ năng lập trình Java Web mà còn hiểu rõ hơn về cách xây dựng một hệ thống web hoàn chỉnh, từ tầng giao diện đến tầng dữ liệu và xử lý nghiệp vụ. Đây là nền tảng quan trọng để phát triển các hệ thống phần mềm phức tạp hơn trong tương lai.
