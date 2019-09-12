//
//  ViewController.swift
//  Lab 1
//
//  Created by Jacky Cheung on 9/11/19.
//  Copyright © 2019 Jacky Cheung. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var icon: UIImageView!
    @IBOutlet weak var text: UILabel!
    
    @IBAction func change(_ sender: UIButton) {
        if sender.tag == 1 {
            icon.image=UIImage(named: "xbox")
            text.text = "The Xbox is a line of consoles created by Microsoft. The current generation has 41.48 million sales as of April 2019.";
        }
        else if sender.tag == 2 {
            icon.image=UIImage(named: "playstation")
            text.text = "The Playstation is a line of consoles created by Sony. The current generation has 92.64 million sales as of April 2019."
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

