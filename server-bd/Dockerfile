FROM mariadb:10.2
LABEL maintainer="luferlira@gmail.com"

ENV MARIADB_ROOT_PASSWORD=toor
ENV MARIADB_DATABASE=students
ENV MARIADB_ROOT_HOST=%

ADD ./script.sql /docker-entrypoint-initdb.d/ddl.sql

CMD ["--default-authentication-plugin=mysql_native_password"]