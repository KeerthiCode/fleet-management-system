async function addDriver() {

    const driver = {
        name: document.getElementById("name").value,
        licenseNumber: document.getElementById("license").value,
        phone: document.getElementById("phone").value
    };

    const response = await fetch("http://localhost:8080/drivers", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(driver)
    });

    const data = await response.json();

    alert("Driver Added Successfully");

    console.log(data);
}