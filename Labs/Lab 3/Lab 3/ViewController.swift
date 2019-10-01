//
//  ViewController.swift
//  Lab 3
//
//  Created by Jacky Cheung on 9/23/19.
//  Copyright © 2019 Jacky Cheung. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var label: UILabel!
    
    @IBOutlet weak var image: UIImageView!
    
    @IBOutlet weak var fontColorSegments: UISegmentedControl!
    @IBAction func fontColor(_ sender: UISegmentedControl) {
        if(fontColorSegments.selectedSegmentIndex == 0){
            label.textColor = UIColor.black
        }
        else if(fontColorSegments.selectedSegmentIndex == 1){
            label.textColor = UIColor.red
        }
    }
    
    @IBOutlet weak var textCaseSegments: UISegmentedControl!
    @IBAction func textCase(_ sender: UISegmentedControl) {
        if(textCaseSegments.selectedSegmentIndex == 0){
            label.text = label.text?.uppercased()
        }
        
        else if(fontColorSegments.selectedSegmentIndex == 1){
            label.text = label.text?.lowercased()
        }
    }
    
    @IBOutlet weak var imageChangeState: UISwitch!
    @IBAction func imageChange(_ sender: UISwitch) {
        if (imageChangeState.isOn){
            image.image = UIImage(named: "180")
        }
        else{
            image.image = UIImage(named: "120")
        }
    }
    
    @IBOutlet weak var textChangeState: UISwitch!
    @IBAction func textChange(_ sender: UISwitch) {
        if(textChangeState.isOn){
            label.text = "Mess with the controls"
        }
        else{
            label.text = "Touch the UI"
        }
    }
    
    
    @IBOutlet weak var slider: UISlider!
    @IBAction func textSize(_ sender: UISlider) {
        self.label.font = UIFont.systemFont(ofSize: CGFloat(slider.value * 20.0))
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

