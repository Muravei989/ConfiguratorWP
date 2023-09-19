class State {
    name = "";
    inputs = [];
    step = 0;

    constructor(name, inputs) {
        this.name = name;
        this.inputs = inputs;
    }

    incrementStep() {
        this.step++;
    }

    dropStep() {
        this.step = 0;
    }

    illuminate() {
        for (let i = 0; i < this.inputs.length; i++) {
            illuminateInput(this.inputs[i]);
        }
    }

    hide() {
        for (let i = 0; i < this.inputs.length; i++) {
            hideInput(this.inputs[i]);
        }
    }
}

let hl8State = new State("heatload8", ["heatload8Box", "checkplaceBox"]);
let hl910State = new State("heatload910", ["heatload910Box"]);
let hl11State = new State("heatload11", ["heatload11Box"]);

let states = [hl8State, hl910State];

let currentState = hl8State;


function hideInput(id) {
    document.getElementById(id).classList.remove("hidden");
}

function illuminateInput(id) {
    document.getElementById(id).classList.add("hidden");
}

function resetInactive() {
    for (const state1 of states) {
        if (!(state1.name === currentState.name)) {
            state1.hide();
            state1.dropStep();
        }
    }
}

function heatLoadToggle() {
    let val = parseInt(document.getElementById("heatLoad").value);
    if (val === 8) {
        currentState = hl8State;
    } else if (val === 9 || val === 10) {
        currentState = hl910State;
    }
    resetInactive();
    currentState.incrementStep();
    currentState.illuminate();
}


function heatload8BoxToggle() {
    resetInactive();
    currentState.incrementStep();
    currentState.illuminate();
}

document.getElementById("heatload8Box").addEventListener('change', heatload8BoxToggle())