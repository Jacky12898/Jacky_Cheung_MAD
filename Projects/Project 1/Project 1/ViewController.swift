//
//  ViewController.swift
//  Project 1
//
//  Created by Jacky Cheung on 9/30/19.
//  Copyright © 2019 Jacky Cheung. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var sliderState = false

    @IBOutlet weak var label: UILabel!
    
    @IBOutlet weak var slider: UISlider!
    
    @IBAction func sliderAction(_ sender: Any) {
        if(sliderState){
            label.transform = CGAffineTransform(translationX: 0, y: CGFloat(slider.value * 100))
        }
        
        else{
            label.transform = CGAffineTransform(translationX: CGFloat(slider.value * 100), y: 0)
        }
        
        if(slider.value == 1){
            hiddenButton.isEnabled = true
        }
    }
    
    @IBOutlet weak var button: UISwitch!
    
    @IBAction func hideButton(_ sender: Any) {
        if(button.isOn){
            hiddenButton.isHidden = false
        }
    }
    
    @IBOutlet weak var hiddenButton: UISwitch!
    
    @IBAction func changeSliderFunction(_ sender: Any) {
        if(hiddenButton.isOn){
            sliderState = true
        }
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let rectangle: CGRect = CGRect(x: 100, y: 200, width: 50, height: 250)
        
        let rectView = UIView(frame: rectangle)
        
        rectView.backgroundColor = UIColor.red
        
        self.view.addSubview(rectView)
    }
}

