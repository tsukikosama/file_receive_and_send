package com.miku.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
    File filesrc;
    Socket socket;
    FileInputStream open;
    FileOutputStream out;

}
