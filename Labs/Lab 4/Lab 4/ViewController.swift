//
//  ViewController.swift
//  Lab 4
//
//  Created by Jacky Cheung on 10/2/19.
//  Copyright © 2019 Jacky Cheung. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var textbox: UITextField!
    
    @IBOutlet weak var stepper: UIStepper!
    
    @IBOutlet weak var stepperLabel: UILabel!
    
    @IBOutlet weak var result: UILabel!
    
    @IBAction func stepperAction(_ sender: Any) {
        stepperLabel.text = String(stepper.value)
    }
    
    func divide(){
        var number1: Float
        var number2: Float
        
        if(textbox.text!.isEmpty){
            let alert = UIAlertController(title: "Warning", message: "Input a number", preferredStyle: UIAlertController.Style.alert)
            
            let ok = UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: nil)
            alert.addAction(ok)
            
            number1 = 0.0
        }
        
        else{
            number1 = Float(textbox.text!)!
        }
        
        number2 = Float(stepper.value)
        
        let total = number1 / number2
        
        result.text = String(total)
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool{
        textField.resignFirstResponder()
        return true
    }
    
    
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        divide()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillShow), name: UIResponder.keyboardWillShowNotification, object: nil)
        
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillHide), name: UIResponder.keyboardWillHideNotification, object: nil)
        
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        
        view.addGestureRecognizer(tap)
        
        textbox.delegate = self
    }
    
    @objc func dismissKeyboard(){
        view.endEditing(true)
    }
    
    @objc func keyboardWillShow(notification: NSNotification){
        if let keyboardSize = (notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue)?.cgRectValue{
            if self.view.frame.origin.y == 0{
                self.view.frame.origin.y -= keyboardSize.height
            }
        }
    }
    
    @objc func keyboardWillHide(notification: NSNotification){
        if ((notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue)?.cgRectValue) != nil{
            if self.view.frame.origin.y != 0{
                self.view.frame.origin.y = 0
            }
        }
    }
}
